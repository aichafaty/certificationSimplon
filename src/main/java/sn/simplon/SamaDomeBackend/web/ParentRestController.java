package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.ParentNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.ParentDTO;
import sn.simplon.SamaDomeBackend.service.ParentImplement;

import java.util.List;
@RestController

public class ParentRestController {
    public ParentImplement parentService;


    public ParentRestController(ParentImplement parentService) {this.parentService = parentService;}

    @GetMapping("/parent")
    public List<ParentDTO> getAll(){
        return parentService.getAllParent();
    }

    @GetMapping("/parent/{id}")
    public ParentDTO getOne(@PathVariable Long id) throws ParentNotFoundException {
        return parentService.getOneParent(id);
    }
    @PostMapping("/parent")
    public ParentDTO save(@RequestBody ParentDTO ParentDTO) throws ParentNotFoundException {
        return parentService.saveParent(ParentDTO);
    }
    @PutMapping("/parent/{id}")
    public ParentDTO update(@PathVariable  Long id,@RequestBody ParentDTO ParentDTO){
        ParentDTO.setId(id);
        return parentService.updateParent(ParentDTO);
    }
    @DeleteMapping("/parent/{id}")
    public void delete(Long id) throws ParentNotFoundException {
        parentService.deleteParent(id);
    }
}
