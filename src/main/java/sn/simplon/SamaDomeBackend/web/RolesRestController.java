package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.RolesNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.RolesDTO;
import sn.simplon.SamaDomeBackend.service.RolesImplement;

import java.util.List;
@RestController
public class RolesRestController {
    public RolesImplement maladieService;

    public RolesRestController(RolesImplement maladieService) {
        this.maladieService = maladieService;
    }

    @GetMapping("/roles")
    public List<RolesDTO> getAll(){
        return maladieService.getAllRoles();
    }

    @GetMapping("/roles/{id}")
    public RolesDTO getOne(@PathVariable Long id) throws RolesNotFoundException {
        return maladieService.getOneRoles(id);
    }
    @PostMapping("/roles")
    public RolesDTO save(@RequestBody RolesDTO RolesDTO) throws RolesNotFoundException {
        return maladieService.saveRoles(RolesDTO);
    }
    @PutMapping("/roles/{id}")
    public RolesDTO update(@PathVariable  Long id,@RequestBody RolesDTO RolesDTO){
        RolesDTO.setId(id);
        return maladieService.updateRoles(RolesDTO);
    }
    @DeleteMapping("/roles/{id}")
    public void delete(Long id) throws RolesNotFoundException {
        maladieService.deleteRoles(id);
    }
}
