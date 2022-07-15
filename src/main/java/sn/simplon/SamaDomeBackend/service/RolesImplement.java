package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.RolesNotFoundException;

import sn.simplon.SamaDomeBackend.dtos.RolesDTO;

import sn.simplon.SamaDomeBackend.entity.Roles;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.RolesRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RolesImplement implements RolesService{

    private  final RolesRepository rolesRepository;
    private Mapper mapperDTO;
    
    public RolesImplement(RolesRepository rolesRepository,Mapper mapperDTO){
        this.rolesRepository=rolesRepository;
        this.mapperDTO=mapperDTO;
    }
    @Override
    public RolesDTO saveRoles(RolesDTO rolesDTO) throws RolesNotFoundException {
        Roles roles =mapperDTO.fromRolesDTO(rolesDTO);
        Roles rolesSave=rolesRepository.save(roles);
        return mapperDTO.fromRoles(rolesSave);
    }

    @Override
    public List<RolesDTO> getAllRoles() {
        List<Roles> rolesList= rolesRepository.findAll();
        List<RolesDTO> rolesDTOS=rolesList.stream()
                .map(roles-> mapperDTO.fromRoles(roles))
                .collect(Collectors.toList());
        return rolesDTOS;
    }

    @Override
    public RolesDTO getOneRoles(Long id) throws RolesNotFoundException {
        Roles roles= rolesRepository.findById(id)
                .orElseThrow(()->new RolesNotFoundException("Cet roles n'existe pas"));
        return mapperDTO.fromRoles(roles);
    }

    @Override
    public RolesDTO updateRoles(RolesDTO rolesDTO) {
        Roles roles=mapperDTO.fromRolesDTO(rolesDTO);
        Roles rolesUpdate=rolesRepository.save(roles);
        return mapperDTO.fromRoles(rolesUpdate);
    }

    @Override
    public void deleteRoles(Long id) throws RolesNotFoundException {
        Roles roles= rolesRepository.findById(id)
                .orElseThrow(()->new RolesNotFoundException("Cet id n'existe pas"));
        rolesRepository.delete(roles);
    }
}
