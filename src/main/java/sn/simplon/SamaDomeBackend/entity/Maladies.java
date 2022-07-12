package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Maladies {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomMaladie;
    private String description;

    @OneToMany(mappedBy = "maladies")
    private List<Vaccins> vaccins;


}
