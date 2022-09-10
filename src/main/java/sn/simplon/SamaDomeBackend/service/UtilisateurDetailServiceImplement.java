package sn.simplon.SamaDomeBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sn.simplon.SamaDomeBackend.entity.Utilisateur;
import sn.simplon.SamaDomeBackend.repository.UtilisateurRepository;
@Service
public class UtilisateurDetailServiceImplement  implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Utilisateur utilisateur=this.utilisateurRepository.findByUsername(username);
            if (utilisateur==null){
                System.out.println("User not found");
                throw new UsernameNotFoundException("No user found ");
            }

             return utilisateur;
    }
}
