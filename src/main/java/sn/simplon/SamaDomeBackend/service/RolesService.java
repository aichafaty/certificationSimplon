package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.RolesNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.RolesDTO;

import java.util.List;

public interface RolesService {
    RolesDTO saveRoles(RolesDTO rolesDTO) throws RolesNotFoundException;
    List<RolesDTO> getAllRoles();
    RolesDTO getOneRoles(Long id) throws RolesNotFoundException;
    RolesDTO updateRoles(RolesDTO rolesDTO);
    void deleteRoles(Long id) throws RolesNotFoundException;
}
