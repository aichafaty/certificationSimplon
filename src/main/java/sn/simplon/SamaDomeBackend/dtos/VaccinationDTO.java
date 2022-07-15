package sn.simplon.SamaDomeBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.simplon.SamaDomeBackend.entity.Carnet;
import sn.simplon.SamaDomeBackend.entity.Vaccins;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class VaccinationDTO {

    private Long id;
    private int age;
    private Date dateVaccination;
    private String observation;
    private Vaccins vaccins;
    private Carnet carnet;
}
