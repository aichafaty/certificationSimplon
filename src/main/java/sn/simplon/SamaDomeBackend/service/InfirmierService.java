package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.InfirmierNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.InfirmierDTO;

import java.util.List;

public interface InfirmierService {
    InfirmierDTO saveInfirmier(InfirmierDTO vaccinationDTO) throws InfirmierNotFoundException;
    List<InfirmierDTO> getAllInfirmier();
    InfirmierDTO getOneInfirmier(Long id) throws InfirmierNotFoundException;
    InfirmierDTO updateInfirmier(InfirmierDTO vaccinationDTO);
    void deleteInfirmier(Long id) throws InfirmierNotFoundException;
}
