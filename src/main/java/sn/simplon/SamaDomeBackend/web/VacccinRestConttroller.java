package sn.simplon.SamaDomeBackend.web;




import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import sn.simplon.SamaDomeBackend.Exception.VaccinsNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.VaccinsDTO;
import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.service.VaccinImplement;

@RestController
@CrossOrigin("*")
//@Slf4j

public class VacccinRestConttroller {

public VaccinImplement vaccinService;

    public VacccinRestConttroller(VaccinImplement vaccinService) {
        this.vaccinService = vaccinService;
    }
    @GetMapping("/vaccins")
    public List<VaccinsDTO> getAll(){
        return vaccinService.getAllVaccins();
    }
    @GetMapping("/vaccins/{id}")
    public VaccinsDTO getOne(@PathVariable Long id) throws VaccinsNotFoundException{
        return vaccinService.getOneVaccin(id);
    }
    @PostMapping("/vaccin")
    public VaccinsDTO save(@RequestBody VaccinsDTO vaccinsDTO) throws VaccinsNotFoundException {
        return vaccinService.saveVaccins(vaccinsDTO);
    }
    @PutMapping("/vaccins/{id}")
    public VaccinsDTO update(@PathVariable  Long id,@RequestBody VaccinsDTO vaccinsDTO){
        vaccinsDTO.setId(id);
        return vaccinService.updateVaccin(vaccinsDTO);
    }
    @DeleteMapping("/vaccins/{id}")
    public void delete(@PathVariable Long id) throws VaccinsNotFoundException {
        vaccinService.deleteVaccin(id);
    }

}
