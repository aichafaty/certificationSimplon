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
public class Vaccination {
    @Id
    private int id;
    private int age;
    private Date dateVaccination;
    private String observation;

    @ManyToOne
    private Vaccins vaccins;

    @ManyToOne
    private Carnet carnet;
}
