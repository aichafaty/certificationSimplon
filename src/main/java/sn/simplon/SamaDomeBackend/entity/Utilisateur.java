package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
    @Id
    private int id;
    private String nom;
    private String prenom;
    private  String adresse;
    private  String email;
    private  String password;
    private Date dateNaissance;
    private String telephone;

}
