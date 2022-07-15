package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.VaccinationNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.VaccinationDTO;

import java.util.List;

public interface VaccinationService {
    VaccinationDTO saveVaccination(VaccinationDTO vaccinationDTO) throws VaccinationNotFoundException;
    List<VaccinationDTO> getAllVaccination();
    VaccinationDTO getOneVaccination(Long id) throws VaccinationNotFoundException;
    VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO);
    void deleteVaccination(Long id) throws VaccinationNotFoundException;
}
