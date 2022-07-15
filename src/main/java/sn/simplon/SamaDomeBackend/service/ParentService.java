package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.ParentNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.ParentDTO;

import java.util.List;

public interface ParentService {
    ParentDTO saveParent(ParentDTO vaccinationDTO) throws ParentNotFoundException;
    List<ParentDTO> getAllParent();
    ParentDTO getOneParent(Long id) throws ParentNotFoundException;
    ParentDTO updateParent(ParentDTO vaccinationDTO);
    void deleteParent(Long id) throws ParentNotFoundException;
}
