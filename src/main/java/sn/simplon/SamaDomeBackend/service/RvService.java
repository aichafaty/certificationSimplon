package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.RvNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.RvDTO;

import java.util.List;
public interface RvService {
    RvDTO saveRv(RvDTO vaccinationDTO) throws RvNotFoundException;
    List<RvDTO> getAllRv();
    RvDTO getOneRv(Long id) throws RvNotFoundException;
    RvDTO updateRv(RvDTO rvDTO);
    void deleteRv(Long id) throws RvNotFoundException;
}
