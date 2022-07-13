package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Vaccins {
    @Id
    private int id;
    private String nomVaccin;
    private String age;
    private String effetSecondaire;
    @ManyToOne
        private Maladies maladies;
    @OneToMany(mappedBy = "vaccins")
        private List<Vaccination> vaccinations;
}
