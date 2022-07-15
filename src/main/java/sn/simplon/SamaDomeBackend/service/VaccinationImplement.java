package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.VaccinationNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.VaccinationDTO;
import sn.simplon.SamaDomeBackend.entity.Vaccination;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.VaccinationRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class VaccinationImplement implements VaccinationService{


    private VaccinationRepository vaccinationRepository;
    private Mapper mapperDTO;

    public VaccinationImplement(VaccinationRepository vaccinationRepository,Mapper mapperDTO){
        this.vaccinationRepository=vaccinationRepository;
        this.mapperDTO=mapperDTO;
    }
    
    
    @Override
    public VaccinationDTO saveVaccination(VaccinationDTO vaccinationDTO) throws VaccinationNotFoundException {
        Vaccination vaccination =mapperDTO.fromVaccinationDTO(vaccinationDTO);
        Vaccination vaccinationSave=vaccinationRepository.save(vaccination);
        return mapperDTO.fromVaccination(vaccinationSave);
    }

    @Override
    public List<VaccinationDTO> getAllVaccination() {
        List<Vaccination> vaccinationList= vaccinationRepository.findAll();
        List<VaccinationDTO> vaccinationDTOS=vaccinationList.stream()
                .map(vaccination-> mapperDTO.fromVaccination(vaccination))
                .collect(Collectors.toList());
        return vaccinationDTOS;
    }

    @Override
    public VaccinationDTO getOneVaccination(Long id) throws VaccinationNotFoundException {
        Vaccination vaccination= vaccinationRepository.findById(id)
                .orElseThrow(()->new VaccinationNotFoundException("Cet vaccination n'existe pas"));
        return mapperDTO.fromVaccination(vaccination);
    }

    @Override
    public VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO) {
        Vaccination vaccination=mapperDTO.fromVaccinationDTO(vaccinationDTO);
        Vaccination vaccinationUpdate=vaccinationRepository.save(vaccination);
        return mapperDTO.fromVaccination(vaccinationUpdate);
    }

    @Override
    public void deleteVaccination(Long id) throws VaccinationNotFoundException {
        Vaccination vaccination= vaccinationRepository.findById(id)
                .orElseThrow(()->new VaccinationNotFoundException("Cet id n'existe pas"));
        vaccinationRepository.delete(vaccination);
    }
}
