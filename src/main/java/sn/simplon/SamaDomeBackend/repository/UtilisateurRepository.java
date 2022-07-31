package sn.simplon.SamaDomeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.simplon.SamaDomeBackend.entity.Utilisateur;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
      List<Utilisateur> findByNameContains(String keyword) ;
}

