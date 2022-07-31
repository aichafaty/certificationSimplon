package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.UtilisateurNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.UtilisateurDTO;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDTO saveUtilisateur(UtilisateurDTO vaccinationDTO) throws UtilisateurNotFoundException;
    List<UtilisateurDTO> getAllUtilisateur();
    UtilisateurDTO getOneUtilisateur(Long id) throws UtilisateurNotFoundException;
    UtilisateurDTO updateUtilisateur(UtilisateurDTO vaccinationDTO);
    void deleteUtilisateur(Long id) throws UtilisateurNotFoundException;

    List<UtilisateurDTO> rechercheUtilisateur(String keyword);
}
