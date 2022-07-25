package sn.simplon.SamaDomeBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.simplon.SamaDomeBackend.entity.Maladies;


@Data @NoArgsConstructor @AllArgsConstructor
public class VaccinsDTO {
    private Long id;
    private String nomVaccin;
    private String age;
    private String effetSecondaire;
    //private Maladies maladies;
}
