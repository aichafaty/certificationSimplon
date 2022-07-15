package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.CarnetNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.CarnetDTO;
import sn.simplon.SamaDomeBackend.service.CarnetImplement;

import java.util.List;
@RestController
public class CarnetRestController {
    public CarnetImplement carnetService;


    public CarnetRestController(CarnetImplement carnetService) {this.carnetService = carnetService;}

    @GetMapping("/carnet")
    public List<CarnetDTO> getAll(){
        return carnetService.getAllCarnet();
    }

    @GetMapping("/carnet/{id}")
    public CarnetDTO getOne(@PathVariable Long id) throws CarnetNotFoundException {
        return carnetService.getOneCarnet(id);
    }
    @PostMapping("/carnet")
    public CarnetDTO save(@RequestBody CarnetDTO CarnetDTO) throws CarnetNotFoundException {
        return carnetService.saveCarnet(CarnetDTO);
    }
    @PutMapping("/carnet/{id}")
    public CarnetDTO update(@PathVariable  Long id,@RequestBody CarnetDTO CarnetDTO){
        CarnetDTO.setId(id);
        return carnetService.updateCarnet(CarnetDTO);
    }
    @DeleteMapping("/carnet/{id}")
    public void delete(Long id) throws CarnetNotFoundException {
        carnetService.deleteCarnet(id);
    }
}
