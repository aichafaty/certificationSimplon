package sn.simplon.SamaDomeBackend.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import sn.simplon.SamaDomeBackend.service.UtilisateurDetailServiceImplement;

@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter{
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UtilisateurDetailServiceImplement utilisateurDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
           final String requestTokenHeader=request.getHeader("Autorization");
           System.out.println(requestTokenHeader);
           String username=null;
           String jwtToken=null;


           if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")){
            jwtToken=requestTokenHeader.substring(7);
            try {
                username=this.jwtUtils.extractUsername(jwtToken);
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                System.out.println("jwt token has expered");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("error");
            }
            
           }else{
            System.out.println("Invalide request");
           }

           if(username!= null && SecurityContextHolder.getContext().getAuthentication()==null)
            {
                final UserDetails userDetails=this.utilisateurDetailsService.loadUserByUsername(username);
                if(this.jwtUtils.validateToken(jwtToken, userDetails)){

                    UsernamePasswordAuthenticationToken usernamePasswordAuthentication  = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
                    
                }
            }else{
                System.out.println("token is non valide");
            }

                filterChain.doFilter(request, response);
       
    }
}
