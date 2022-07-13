package sn.simplon.SamaDomeBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class VaccinsDTO {
    private int id;
    private String nomVaccin;
    private String age;
    private String effetSecondaire;
}
