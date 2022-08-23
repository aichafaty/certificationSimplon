package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.RolesNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.RolesDTO;
import sn.simplon.SamaDomeBackend.service.RolesImplement;

import java.util.List;
@RestController
@CrossOrigin("*")
public class RolesRestController {
    public RolesImplement rolesService;

    public RolesRestController(RolesImplement rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/roles")
    public List<RolesDTO> getAll(){
        return rolesService.getAllRoles();
    }

    @GetMapping("/roles/{id}")
    public RolesDTO getOne(@PathVariable Long id) throws RolesNotFoundException {
        return rolesService.getOneRoles(id);
    }
    @PostMapping("/roles")
    public RolesDTO save(@RequestBody RolesDTO RolesDTO) throws RolesNotFoundException {
        return rolesService.saveRoles(RolesDTO);
    }
    @PutMapping("/roles/{id}")
    public RolesDTO update(@PathVariable  Long id,@RequestBody RolesDTO RolesDTO){
        RolesDTO.setId(id);
        return rolesService.updateRoles(RolesDTO);
    }
    @DeleteMapping("/roles/{id}")
    public void delete(@PathVariable Long id) throws RolesNotFoundException {
        rolesService.deleteRoles(id);
    }
}
