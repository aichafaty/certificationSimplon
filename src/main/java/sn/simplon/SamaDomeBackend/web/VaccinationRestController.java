package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.VaccinationNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.VaccinationDTO;
import sn.simplon.SamaDomeBackend.service.VaccinationImplement;

import java.util.List;

@RestController
public class VaccinationRestController {
    public VaccinationImplement vaccinationService;

    public VaccinationRestController(VaccinationImplement vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @GetMapping("/vaccination")
    public List<VaccinationDTO> getAll(){
        return vaccinationService.getAllVaccination();
    }

    @GetMapping("/vaccination/{id}")
    public VaccinationDTO getOne(@PathVariable Long id) throws VaccinationNotFoundException {
        return vaccinationService.getOneVaccination(id);
    }
    @PostMapping("/vaccination")
    public VaccinationDTO save(@RequestBody VaccinationDTO VaccinationDTO) throws VaccinationNotFoundException {
        return vaccinationService.saveVaccination(VaccinationDTO);
    }
    @PutMapping("/vaccination/{id}")
    public VaccinationDTO update(@PathVariable  Long id,@RequestBody VaccinationDTO VaccinationDTO){
        VaccinationDTO.setId(id);
        return vaccinationService.updateVaccination(VaccinationDTO);
    }
    @DeleteMapping("/vaccination/{id}")
    public void delete(Long id) throws VaccinationNotFoundException {
        vaccinationService.deleteVaccination(id);
    }
}
