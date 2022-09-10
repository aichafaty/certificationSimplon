
package sn.simplon.SamaDomeBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;

    @OneToMany(mappedBy = "roles")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UserRoles> userRolesList;


//    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
//    private Collection<Utilisateur> utilisateurs=new ArrayList<>();
}