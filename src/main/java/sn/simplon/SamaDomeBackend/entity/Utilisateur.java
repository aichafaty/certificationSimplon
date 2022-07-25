
package sn.simplon.SamaDomeBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

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
    //PERMET DE TENIR COMPTE DE LA classe quen mode lecture
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Rv> rvList;

    @OneToMany(mappedBy = "utilisateur")
    //PERMET DE TENIR COMPTE DE LA classe quen mode lecture
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Vaccins> vaccins;

    @OneToMany(mappedBy = "utilisateur")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "utilisateur")
    private List<UserRoles> userRoles;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Roles>  roles=new ArrayList<>();

}
















