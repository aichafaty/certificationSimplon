package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Carnet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String examComplementaire;
    private String gynecologue;
    private String numbGynecologue;

    @OneToMany(mappedBy = "carnet")
    private List<Vaccination> vaccinations;

    @OneToMany(mappedBy = "carnet")
    private List<Rv> rvs;

    @ManyToOne
    private Parent parent;

}
