package sn.simplon.SamaDomeBackend.dtos;

import lombok.Data;
import sn.simplon.SamaDomeBackend.entity.Roles;

@Data
 public class AdminDTO {
    private Long id;
    private Roles roles;
}
