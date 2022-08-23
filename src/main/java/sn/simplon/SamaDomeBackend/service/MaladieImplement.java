package sn.simplon.SamaDomeBackend.service;
import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.MaladieNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.MaladiesDTO;
import sn.simplon.SamaDomeBackend.entity.Maladies;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.MaladiesRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class MaladieImplement implements MaladiesService{
    private  final MaladiesRepository maladiesRepository;
    private  Mapper mapperDTO;

    public MaladieImplement(MaladiesRepository maladiesRepository,Mapper mapperDTO){
        this.maladiesRepository=maladiesRepository;
        this.mapperDTO=mapperDTO;
    }
    @Override
    public MaladiesDTO saveMaladie(MaladiesDTO maladiesDTO) throws MaladieNotFoundException {
        Maladies maladies = mapperDTO.fromMaladiesDTO(maladiesDTO);
        Maladies maladieSave=maladiesRepository.save(maladies);
        return mapperDTO.fromMaladies(maladieSave);
    }

    @Override
    public List<MaladiesDTO> getAllMaladies() {
        List<Maladies> maladiesList= maladiesRepository.findAll();
        List<MaladiesDTO> maladiesDTOS=maladiesList.stream()
                .map(maladies-> mapperDTO.fromMaladies(maladies))
                .collect(Collectors.toList());
        return maladiesDTOS;
    }

    @Override
    public MaladiesDTO getOneMaladie(Long id) throws MaladieNotFoundException {
        Maladies maladies= maladiesRepository.findById(id)
                .orElseThrow(()->new MaladieNotFoundException("Cet maladie n'existe pas"));
        return mapperDTO.fromMaladies(maladies);
    }

    @Override
    public MaladiesDTO updateMaladie(MaladiesDTO maladiesDTO) {
        Maladies maladies=mapperDTO.fromMaladiesDTO(maladiesDTO);
        Maladies maladieUpdate=maladiesRepository.save(maladies);
        return mapperDTO.fromMaladies(maladieUpdate);
    }

    @Override
    public void deleteMaladie(Long id) throws MaladieNotFoundException {
        Maladies maladies= maladiesRepository.findById(id)
                .orElseThrow(()->new MaladieNotFoundException("Cet id n'existe pas"));
        maladiesRepository.delete(maladies);
    }
}
