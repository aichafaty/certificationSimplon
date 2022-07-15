package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
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
    private List<Parent> parentList;

    @OneToMany(mappedBy = "roles")
    private List<Admin> adminList;

    @OneToMany(mappedBy = "roles")
    private List<Infirmier> infirmierList;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Collection<Utilisateur> utilisateurs=new ArrayList<>();
}
