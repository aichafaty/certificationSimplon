package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Infirmier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "infirmier")
    private List<Vaccination> vaccinationList;

    @OneToMany(mappedBy ="infirmier" )
    private List<Rv> rvList;
    @ManyToOne
    private Roles roles;
}
