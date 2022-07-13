package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.MaladieNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.MaladiesDTO;
import sn.simplon.SamaDomeBackend.dtos.VaccinsDTO;
import sn.simplon.SamaDomeBackend.entity.Maladies;
import sn.simplon.SamaDomeBackend.entity.Vaccins;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.MaladiesRepository;


import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class MaladieImplement implements MaladiesService{
    private MaladiesRepository maladiesRepository;
    private Mapper mapperDTO;

    public MaladieImplement(MaladiesRepository maladiesRepository,Mapper mapperDTO){
        this.maladiesRepository=maladiesRepository;
        this.mapperDTO=mapperDTO;
    }
    @Override
    public MaladiesDTO saveMaladie(MaladiesDTO maladiesDTO) throws MaladieNotFoundException {
        Maladies maladies =mapperDTO.fromMaladiesDTO(maladiesDTO);
        Maladies maladieSave=maladiesRepository.save(maladies);
        return mapperDTO.fromMaladies(maladieSave);
    }

    @Override
    public List<MaladiesDTO> getAllMaladies() {
        return null;
    }

    @Override
    public MaladiesDTO getOneMaladie(Long id) throws MaladieNotFoundException {
        return null;
    }

    @Override
    public VaccinsDTO updateMaladie(MaladiesDTO maladiesDTO) {
        return null;
    }

    @Override
    public void deleteMaladie(Long id) throws MaladieNotFoundException {

    }
}
