package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.MaladieNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.MaladiesDTO;

import java.util.List;

public interface MaladiesService {
    MaladiesDTO saveMaladie(MaladiesDTO maladiesDTO) throws MaladieNotFoundException;
    List<MaladiesDTO> getAllMaladies();
    MaladiesDTO getOneMaladie(Long id) throws MaladieNotFoundException;
    MaladiesDTO updateMaladie(MaladiesDTO maladiesDTO);
    void deleteMaladie(Long id) throws MaladieNotFoundException;
}
