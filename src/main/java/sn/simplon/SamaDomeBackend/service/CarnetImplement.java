package sn.simplon.SamaDomeBackend.service;


import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.CarnetNotFoundException;

import sn.simplon.SamaDomeBackend.dtos.CarnetDTO;
import sn.simplon.SamaDomeBackend.entity.Carnet;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.CarnetRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class CarnetImplement implements CarnetService{
    private  CarnetRepository carnetRepository;
    private Mapper mapperDTO;
    @Override
    public CarnetDTO saveCarnet(CarnetDTO carnetDTO) throws CarnetNotFoundException {
        Carnet carnet =mapperDTO.fromCarnetDTO(carnetDTO);
        Carnet utilisateurSave=carnetRepository.save(carnet);
        return mapperDTO.fromCarnet(utilisateurSave);
    }
    @Override
    public List<CarnetDTO> getAllCarnet() {
      List<Carnet> carnetList= carnetRepository.findAll();
        List<CarnetDTO> carnetDTOS=carnetList.stream()
         .map(carnet-> mapperDTO.fromCarnet(carnet))
         .collect(Collectors.toList());
        return carnetDTOS;
    }
    @Override
    public CarnetDTO getOneCarnet(Long id) throws CarnetNotFoundException {
       Carnet carnet= carnetRepository.findById(id)
       . orElseThrow(()->new CarnetNotFoundException("Cet carnet n'existe pas"));
        return mapperDTO.fromCarnet(carnet);
    }
    @Override
    public CarnetDTO updateCarnet(CarnetDTO carnetDTO) {
        Carnet carnet=mapperDTO.fromCarnetDTO(carnetDTO);
        Carnet carnetUpdate=carnetRepository.save(carnet);
        return mapperDTO.fromCarnet(carnetUpdate);
    }
    @Override
    public void deleteCarnet(Long id) throws CarnetNotFoundException {
        Carnet carnet= carnetRepository.findById(id)
         .orElseThrow(()->new CarnetNotFoundException("Cet id n'existe pas"));
        carnetRepository.delete(carnet);
    }
}
