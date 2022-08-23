package sn.simplon.SamaDomeBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.simplon.SamaDomeBackend.entity.Rv;
import sn.simplon.SamaDomeBackend.entity.Utilisateur;
import sn.simplon.SamaDomeBackend.entity.Vaccination;


import java.util.Date;
import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
public class CarnetDTO {
    private Long id;
    private String numeroCarnet;
    private String nomEnfant;
    private String prenomEnfant;
    private Date dateNaissance;
    private String lieuNaiss;
    private String poids;
    private String taille;
    private String sexe;
    private String prenomPere;
    private String nomPere;
    private String prenomMere;
    private String nomMere;
    private String antecedent;
//    private String examComplementaire;
//    private String gynecologue;
//    private String numbGynecologue;

    private List<Vaccination> vaccinations;
    private List<Rv> rvs;
   private Utilisateur utilisateur;

}
