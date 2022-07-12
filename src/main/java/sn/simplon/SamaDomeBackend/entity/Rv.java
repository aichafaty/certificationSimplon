package sn.simplon.SamaDomeBackend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
 @Data @NoArgsConstructor @AllArgsConstructor
public class Rv {
    @Id
    private int id;
    private Date dateRv;
    @ManyToOne
    private Carnet carnet;

}
