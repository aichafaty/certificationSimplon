package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.CarnetNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.CarnetDTO;

import java.util.List;

public interface CarnetService {
    CarnetDTO saveCarnet(CarnetDTO vaccinationDTO) throws CarnetNotFoundException;
    List<CarnetDTO> getAllCarnet();
    CarnetDTO getOneCarnet(Long id) throws CarnetNotFoundException;
    CarnetDTO updateCarnet(CarnetDTO vaccinationDTO);
    void deleteCarnet(Long id) throws CarnetNotFoundException;
}
