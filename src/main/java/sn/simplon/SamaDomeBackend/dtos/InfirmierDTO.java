package sn.simplon.SamaDomeBackend.dtos;

import lombok.Data;
import sn.simplon.SamaDomeBackend.entity.Roles;

@Data
public class InfirmierDTO {
    private Long id;
    private Roles roles;
}
