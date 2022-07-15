package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.InfirmierNotFoundException;

import sn.simplon.SamaDomeBackend.dtos.InfirmierDTO;

import sn.simplon.SamaDomeBackend.entity.Infirmier;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.InfirmierRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InfirmierImplement implements InfirmierService{
    private InfirmierRepository infirmierRepository;
    private Mapper mapperDTO;
    
    @Override
    public InfirmierDTO saveInfirmier(InfirmierDTO infirmierDTO) throws InfirmierNotFoundException {
        Infirmier infirmier =mapperDTO.fromInfirmierDTO(infirmierDTO);
        Infirmier utilisateurSave=infirmierRepository.save(infirmier);
        return mapperDTO.fromInfirmier(utilisateurSave);
    }

    @Override
    public List<InfirmierDTO> getAllInfirmier() {
        List<Infirmier> infirmierList= infirmierRepository.findAll();
        List<InfirmierDTO> infirmierDTOS=infirmierList.stream()
                .map(infirmier-> mapperDTO.fromInfirmier(infirmier))
                .collect(Collectors.toList());
        return infirmierDTOS;
    }

    @Override
    public InfirmierDTO getOneInfirmier(Long id) throws InfirmierNotFoundException {
        Infirmier infirmier= infirmierRepository.findById(id)
                . orElseThrow(()->new InfirmierNotFoundException("Cet infirmier n'existe pas"));
        return mapperDTO.fromInfirmier(infirmier);
    }

    @Override
    public InfirmierDTO updateInfirmier(InfirmierDTO infirmierDTO) {
        Infirmier infirmier=mapperDTO.fromInfirmierDTO(infirmierDTO);
        Infirmier infirmierUpdate=infirmierRepository.save(infirmier);
        return mapperDTO.fromInfirmier(infirmierUpdate);
    }

    @Override
    public void deleteInfirmier(Long id) throws InfirmierNotFoundException {
        Infirmier infirmier= infirmierRepository.findById(id)
                .orElseThrow(()->new InfirmierNotFoundException("Cet id n'existe pas"));
        infirmierRepository.delete(infirmier);
    }
}
