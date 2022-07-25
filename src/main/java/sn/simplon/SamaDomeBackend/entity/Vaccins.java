package sn.simplon.SamaDomeBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Vaccins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomVaccin;
    private String age;
    private String effetSecondaire;
    @ManyToOne
        private Maladies maladies;

    @OneToMany(mappedBy = "vaccins")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private List<Vaccination> vaccinations;
    @ManyToOne
    private Utilisateur utilisateur;

}
