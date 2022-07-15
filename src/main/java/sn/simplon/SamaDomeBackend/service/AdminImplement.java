package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.AdminNotFoundException;
import sn.simplon.SamaDomeBackend.Exception.AdminNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.AdminDTO;
import sn.simplon.SamaDomeBackend.dtos.AdminDTO;
import sn.simplon.SamaDomeBackend.entity.Admin;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.AdminRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional



public class AdminImplement implements AdminService{

    private AdminRepository adminRepository;
    private Mapper mapperDTO;
    @Override
    public AdminDTO saveAdmin(AdminDTO adminDTO) throws AdminNotFoundException {
        Admin admin =mapperDTO.fromAdminDTO(adminDTO);
        Admin adminSave=adminRepository.save(admin);
        return mapperDTO.fromAdmin(adminSave);
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        List<Admin> adminList= adminRepository.findAll();
        List<AdminDTO> adminDTOS=adminList.stream()
        .map(admin-> mapperDTO.fromAdmin(admin))
        .collect(Collectors.toList());
        return adminDTOS;
    }

    @Override
    public AdminDTO getOneAdmin(Long id) throws AdminNotFoundException {
        Admin admin= adminRepository.findById(id)
                . orElseThrow(()->new AdminNotFoundException("Cet admin n'existe pas"));
        return mapperDTO.fromAdmin(admin);
    }

    @Override
    public AdminDTO updateAdmin(AdminDTO adminDTO) {
        Admin admin=mapperDTO.fromAdminDTO(adminDTO);
        Admin adminUpdate=adminRepository.save(admin);
        return mapperDTO.fromAdmin(adminUpdate);
    }

    @Override
    public void deleteAdmin(Long id) throws AdminNotFoundException {
        Admin admin= adminRepository.findById(id)
                .orElseThrow(()->new AdminNotFoundException("Cet id n'existe pas"));
        adminRepository.delete(admin);
    }
}
