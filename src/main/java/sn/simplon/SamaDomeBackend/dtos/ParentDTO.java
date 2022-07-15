package sn.simplon.SamaDomeBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.simplon.SamaDomeBackend.entity.Roles;

@Data @AllArgsConstructor @NoArgsConstructor
public class ParentDTO {
    private Long id;
    private Roles roles;

}
