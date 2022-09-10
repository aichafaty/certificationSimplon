package sn.simplon.SamaDomeBackend.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sn.simplon.SamaDomeBackend.config.JwtUtils;
import sn.simplon.SamaDomeBackend.entity.JwtResponse;
import sn.simplon.SamaDomeBackend.entity.JwtRequest;
import sn.simplon.SamaDomeBackend.entity.Utilisateur;
import sn.simplon.SamaDomeBackend.service.UtilisateurDetailServiceImplement;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UtilisateurDetailServiceImplement userDetailsService;

    @Autowired
    public AuthenticateController(AuthenticationManager authenticationManager, UtilisateurDetailServiceImplement userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping(path="/generate-token",consumes = MediaType.APPLICATION_JSON_VALUE)
       public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest ) throws Exception {
            try {
                    authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
            }catch (UsernameNotFoundException e){
                e.printStackTrace();
                throw new Exception("User not found");

            }
               UserDetails userDetails= this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
               String token=this.jwtUtils.generateToken(userDetails);
               return ResponseEntity.ok(new JwtResponse(token));
       }


    private void authenticate(String username,String password) throws Exception
    {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            
        } catch (DisabledException e) {
            throw new Exception("USER DISEABLE " +e.getMessage());
        }catch(BadCredentialsException e){
            throw new Exception("Invalid Cretial" +e.getMessage());

        }

    }

    //return detail of utilisateur current
    @GetMapping(path = "/current-user")
    
    private Utilisateur getCurrentUtilisateur(Principal principal){
       return  ((Utilisateur) this.userDetailsService.loadUserByUsername(principal.getName()));             
    }

}
 