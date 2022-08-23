package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.RvNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.RvDTO;
import sn.simplon.SamaDomeBackend.service.RvImplement;

import java.util.List;
@RestController
@CrossOrigin("*")
public class RvRestController {
    public RvImplement rvService;

    public RvRestController(RvImplement rvService) {this.rvService = rvService;}

    @GetMapping("/rvs")
    public List<RvDTO> getAll(){
        return rvService.getAllRv();
    }

    @GetMapping("/rv/{id}")
    public RvDTO getOne(@PathVariable Long id) throws RvNotFoundException {
        return rvService.getOneRv(id);
    }
    @PostMapping("/rv")
    public RvDTO save(@RequestBody RvDTO rvDTO) throws RvNotFoundException {
        return rvService.saveRv(rvDTO);
    }
    @PutMapping("/rv/{id}")
    public RvDTO update(@PathVariable  Long id,@RequestBody RvDTO RvDTO){
        RvDTO.setId(id);
        return rvService.updateRv(RvDTO);
    }
    @DeleteMapping("/rv/{id}")
    public void delete(@PathVariable Long id) throws RvNotFoundException {
        rvService.deleteRv(id);
    }
}
