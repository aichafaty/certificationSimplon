package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.AdminNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.AdminDTO;

import java.util.List;

public interface AdminService {
    
        AdminDTO saveAdmin(AdminDTO vaccinationDTO) throws AdminNotFoundException;
        List<AdminDTO> getAllAdmin();
        AdminDTO getOneAdmin(Long id) throws AdminNotFoundException;
        AdminDTO updateAdmin(AdminDTO vaccinationDTO);
        void deleteAdmin(Long id) throws AdminNotFoundException;
    
    
}
