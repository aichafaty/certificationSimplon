package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.MaladieNotFoundException;

import sn.simplon.SamaDomeBackend.dtos.MaladiesDTO;
import sn.simplon.SamaDomeBackend.service.MaladieImplement;

import java.util.List;
@RestController
public class MaladieRestController {
    public MaladieImplement maladieService;

    public MaladieRestController(MaladieImplement maladieService) {
        this.maladieService = maladieService;
    }

    @GetMapping("/maladies")
    public List<MaladiesDTO> getAll(){
        return maladieService.getAllMaladies();
    }

    @GetMapping("/maladies/{id}")
    public MaladiesDTO getOne(@PathVariable Long id) throws MaladieNotFoundException {
        return maladieService.getOneMaladie(id);
    }
    @PostMapping("/maladies")
    public MaladiesDTO save(@RequestBody MaladiesDTO MaladiesDTO) throws MaladieNotFoundException {
        return maladieService.saveMaladie(MaladiesDTO);
    }
    @PutMapping("/maladies/{id}")
    public MaladiesDTO update(@PathVariable  Long id,@RequestBody MaladiesDTO MaladiesDTO){
        MaladiesDTO.setId(id);
        return maladieService.updateMaladie(MaladiesDTO);
    }
    @DeleteMapping("/maladies/{id}")
    public void delete(Long id) throws MaladieNotFoundException {
        maladieService.deleteMaladie(id);
    }
}
