package sn.simplon.SamaDomeBackend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
 @Data @NoArgsConstructor @AllArgsConstructor
public class Rv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateRv;
    @ManyToOne
    private Carnet carnet;

    @ManyToOne
    private Utilisateur utilisateur;


}
