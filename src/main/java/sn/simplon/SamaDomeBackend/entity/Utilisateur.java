
package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private  String adresse;
    private  String email;
    private  String password;
    private Date dateNaissance;
    private String telephone;

    @OneToMany(mappedBy = "utilisateur")
    private List<Rv> rvList;

    @OneToMany(mappedBy = "utilisateur")
    private List<Vaccins> vaccins;

    @OneToMany(mappedBy = "utilisateur")
    private List<Notification> notifications;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles>  roles=new ArrayList<>();

}
















