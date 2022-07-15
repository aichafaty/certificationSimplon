package sn.simplon.SamaDomeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.simplon.SamaDomeBackend.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

}

