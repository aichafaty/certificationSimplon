package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.ParentNotFoundException;
import sn.simplon.SamaDomeBackend.Exception.ParentNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.ParentDTO;
import sn.simplon.SamaDomeBackend.dtos.ParentDTO;
import sn.simplon.SamaDomeBackend.entity.Parent;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.ParentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParentImplement implements ParentService{
    private ParentRepository parentRepository;
    private Mapper mapperDTO;
    
    @Override
    public ParentDTO saveParent(ParentDTO parentDTO) throws ParentNotFoundException {
        Parent parent =mapperDTO.fromParentDTO(parentDTO);
        Parent utilisateurSave=parentRepository.save(parent);
        return mapperDTO.fromParent(utilisateurSave);
    }

    @Override
    public List<ParentDTO> getAllParent() {
        List<Parent> parentList= parentRepository.findAll();
        List<ParentDTO> parentDTOS=parentList.stream()
                .map(parent-> mapperDTO.fromParent(parent))
                .collect(Collectors.toList());
        return parentDTOS;
    }

    @Override
    public ParentDTO getOneParent(Long id) throws ParentNotFoundException {
        Parent parent= parentRepository.findById(id)
                .orElseThrow(()->new ParentNotFoundException("Cet parent n'existe pas"));
        return mapperDTO.fromParent(parent);
    }

    @Override
    public ParentDTO updateParent(ParentDTO parentDTO) {
        Parent parent=mapperDTO.fromParentDTO(parentDTO);
        Parent parentUpdate=parentRepository.save(parent);
        return mapperDTO.fromParent(parentUpdate);
    }

    @Override
    public void deleteParent(Long id) throws ParentNotFoundException {
        Parent parent= parentRepository.findById(id)
                .orElseThrow(()->new ParentNotFoundException("Cet id n'existe pas"));
        parentRepository.delete(parent);
    }
}
