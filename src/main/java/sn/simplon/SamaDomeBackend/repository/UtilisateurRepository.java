package sn.simplon.SamaDomeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import sn.simplon.SamaDomeBackend.entity.Utilisateur;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
      @Query("SELECT u FROM Utilisateur u where u.prenom like :kw")
      List<Utilisateur> rechercheUtilisateur(@Param("kw") String keyword) ;
      Utilisateur findByUsername(String username);


//      Optional<Utilisateur> findByEmail(String email);
      
}

