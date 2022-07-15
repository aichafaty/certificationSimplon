package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "admin")
    private List<Notification> notificationList ;

    @OneToMany(mappedBy = "admin")
    private List<Vaccins> vaccinsList;

    @ManyToOne
    private Roles roles;

}
