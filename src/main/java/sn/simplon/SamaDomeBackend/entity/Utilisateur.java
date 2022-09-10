
package sn.simplon.SamaDomeBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Utilisateur implements UserDetails {
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
    private String username;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE })
    //PERMET DE TENIR COMPTE DE LA classe quen mode lecture
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Rv> rvList;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE })
    //PERMET DE TENIR COMPTE DE LA classe quen mode lecture
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Vaccins> vaccins;
    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE })
    //PERMET DE TENIR COMPTE DE LA classe quen mode lecture
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UserRoles> userRoles;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Roles>  roles=new ArrayList<>();
        @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE })
        //PERMET DE TENIR COMPTE DE LA classe quen mode lecture
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private List<Carnet> carnets;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE })
    //PERMET DE TENIR COMPTE DE LA classe quen mode lecture
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Vaccination> vaccinations;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> set=new HashSet<>();
        if(userRoles!=null){
//            for(UserRoles userRoles : userRoles){
//                set.add(new Authority(userRoles.getRoles().getLibelle()));
//            }
            this.userRoles.forEach(userRoles ->{
                set.add(new Authority(userRoles.getRoles().getLibelle()));
            } );
        }
        return set;
    }

//    @Override
//    public String getUsername() {
//        return username;
//    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
















