package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.InfirmierNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.InfirmierDTO;
import sn.simplon.SamaDomeBackend.service.InfirmierImplement;

import java.util.List;
@RestController

public class InfirmierRestController {
    public InfirmierImplement infirmierService;


    public InfirmierRestController(InfirmierImplement infirmierService) {this.infirmierService = infirmierService;}

    @GetMapping("/infirmier")
    public List<InfirmierDTO> getAll(){
        return infirmierService.getAllInfirmier();
    }

    @GetMapping("/infirmier/{id}")
    public InfirmierDTO getOne(@PathVariable Long id) throws InfirmierNotFoundException {
        return infirmierService.getOneInfirmier(id);
    }
    @PostMapping("/infirmier")
    public InfirmierDTO save(@RequestBody InfirmierDTO InfirmierDTO) throws InfirmierNotFoundException {
        return infirmierService.saveInfirmier(InfirmierDTO);
    }
    @PutMapping("/infirmier/{id}")
    public InfirmierDTO update(@PathVariable  Long id,@RequestBody InfirmierDTO InfirmierDTO){
        InfirmierDTO.setId(id);
        return infirmierService.updateInfirmier(InfirmierDTO);
    }
    @DeleteMapping("/infirmier/{id}")
    public void delete(Long id) throws InfirmierNotFoundException {
        infirmierService.deleteInfirmier(id);
    }

}
