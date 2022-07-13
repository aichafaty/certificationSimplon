package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.VaccinsNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.VaccinsDTO;
import sn.simplon.SamaDomeBackend.entity.Vaccins;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.VaccinsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class VaccinImplement implements IVaccinService {
private VaccinsRepository vaccinsRepository;
private Mapper mapperDTO;
public VaccinImplement(VaccinsRepository vaccinsRepository,Mapper mapperDTO){
    this.vaccinsRepository=vaccinsRepository;
    this.mapperDTO=mapperDTO;
}
    @Override
    public VaccinsDTO saveVaccins(VaccinsDTO vaccinsDTO) throws VaccinsNotFoundException {
        Vaccins vaccins=mapperDTO.fromVaccinsDTO(vaccinsDTO);
        Vaccins vaccinsSave=vaccinsRepository.save(vaccins);
        return mapperDTO.fromVaccins(vaccinsSave);
    }

//    private void vaccinsExiste(String nomVaccin, String effetSecondaire, String age) {
//    }

    @Override
    public List<VaccinsDTO> getAllVaccins() {
        List<Vaccins> vaccinsList= vaccinsRepository.findAll();
        List<VaccinsDTO> vaccinsDTOS=vaccinsList.stream()
                .map(vaccins -> mapperDTO.fromVaccins(vaccins))
                .collect(Collectors.toList());
                return vaccinsDTOS;
    }

    @Override
    public VaccinsDTO getOneVaccin(Long id) throws VaccinsNotFoundException {
        Vaccins vaccins= vaccinsRepository.findById(id)
                .orElseThrow(()->new VaccinsNotFoundException("Cet vaccin n'existe pas"));
        return mapperDTO.fromVaccins(vaccins);

    }

    @Override
    public VaccinsDTO updateVaccin(VaccinsDTO vaccinsDTO) {
        Vaccins vaccins=mapperDTO.fromVaccinsDTO(vaccinsDTO);
        Vaccins vaccinUpdate=vaccinsRepository.save(vaccins);
        return mapperDTO.fromVaccins(vaccinUpdate);
    }

    @Override
    public void deleteVaccin(Long id) throws VaccinsNotFoundException {
        Vaccins vaccins=vaccinsRepository.findById(id)
                .orElseThrow(()->new VaccinsNotFoundException("Cet id n'existe pas"));
        vaccinsRepository.delete(vaccins);
    }
}
