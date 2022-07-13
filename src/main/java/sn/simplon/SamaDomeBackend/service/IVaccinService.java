package sn.simplon.SamaDomeBackend.service;


import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.VaccinsNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.VaccinsDTO;

import java.util.List;

@Service

public interface IVaccinService {
   VaccinsDTO saveVaccins(VaccinsDTO vaccinsDTO) throws VaccinsNotFoundException;
    List<VaccinsDTO> getAllVaccins();
    VaccinsDTO getOneVaccin(Long id) throws VaccinsNotFoundException;
    VaccinsDTO updateVaccin(VaccinsDTO vaccinsDTO);
    void deleteVaccin(Long id) throws VaccinsNotFoundException;


}
