package sn.simplon.SamaDomeBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.simplon.SamaDomeBackend.entity.Carnet;
import sn.simplon.SamaDomeBackend.entity.Utilisateur;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class RvDTO {
    private Long id;
    private Date dateRv;
    private Carnet carnet;
    private Utilisateur utilisateur;
}
