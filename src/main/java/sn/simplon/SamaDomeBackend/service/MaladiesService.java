package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.MaladieNotFoundException;
import sn.simplon.SamaDomeBackend.Exception.VaccinsNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.MaladiesDTO;
import sn.simplon.SamaDomeBackend.dtos.VaccinsDTO;

import java.util.List;

public interface MaladiesService {
    MaladiesDTO saveMaladie(MaladiesDTO maladiesDTO) throws MaladieNotFoundException;
    List<MaladiesDTO> getAllMaladies();
    MaladiesDTO getOneMaladie(Long id) throws MaladieNotFoundException;
    VaccinsDTO updateMaladie(MaladiesDTO maladiesDTO);
    void deleteMaladie(Long id) throws MaladieNotFoundException;
}
