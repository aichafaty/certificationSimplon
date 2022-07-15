package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.AdminNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.AdminDTO;
import sn.simplon.SamaDomeBackend.service.AdminImplement;

import java.util.List;
@RestController
public class AdminRestController {
    public AdminImplement adminService;


    public AdminRestController(AdminImplement adminService) {this.adminService = adminService;}

    @GetMapping("/admin")
    public List<AdminDTO> getAll(){
        return adminService.getAllAdmin();
    }

    @GetMapping("/admin/{id}")
    public AdminDTO getOne(@PathVariable Long id) throws AdminNotFoundException {
        return adminService.getOneAdmin(id);
    }
    @PostMapping("/admin")
    public AdminDTO save(@RequestBody AdminDTO AdminDTO) throws AdminNotFoundException {
        return adminService.saveAdmin(AdminDTO);
    }
    @PutMapping("/admin/{id}")
    public AdminDTO update(@PathVariable  Long id,@RequestBody AdminDTO AdminDTO){
        AdminDTO.setId(id);
        return adminService.updateAdmin(AdminDTO);
    }
    @DeleteMapping("/admin/{id}")
    public void delete(Long id) throws AdminNotFoundException {
        adminService.deleteAdmin(id);
    }
}
