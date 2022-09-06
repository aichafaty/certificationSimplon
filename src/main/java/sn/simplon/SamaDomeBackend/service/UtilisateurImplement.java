package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.UtilisateurNotFoundException;

import sn.simplon.SamaDomeBackend.dtos.UtilisateurDTO;

import sn.simplon.SamaDomeBackend.entity.Utilisateur;
import sn.simplon.SamaDomeBackend.mappers.Mapper;

import sn.simplon.SamaDomeBackend.repository.UtilisateurRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class UtilisateurImplement implements UtilisateurService{
    private UtilisateurRepository utilisateurRepository;
    private Mapper mapperDTO;
    public UtilisateurImplement(UtilisateurRepository utilisateurRepository, Mapper mapperDTO){
        this.utilisateurRepository=utilisateurRepository;
        this.mapperDTO=mapperDTO;
    }
    
    @Override
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO) throws UtilisateurNotFoundException {
        Utilisateur utilisateur =mapperDTO.fromUtilisateurDTO(utilisateurDTO);
        Utilisateur maladieSave=utilisateurRepository.save(utilisateur);
        return mapperDTO.fromUtilisateur(maladieSave);
    }

    @Override
    public List<UtilisateurDTO> getAllUtilisateur() {
        List<Utilisateur> utilisateurList= utilisateurRepository.findAll();
        List<UtilisateurDTO> utilisateurDTOS=utilisateurList.stream()
                .map(utilisateur-> mapperDTO.fromUtilisateur(utilisateur))
                .collect(Collectors.toList());
        return utilisateurDTOS;
    }

    @Override
    public UtilisateurDTO getOneUtilisateur(Long id) throws UtilisateurNotFoundException {
        Utilisateur utilisateur= utilisateurRepository.findById(id)
                .orElseThrow(()->new UtilisateurNotFoundException("Cet utilisateur n'existe pas"));
        return mapperDTO.fromUtilisateur(utilisateur);
    }

    @Override
    public UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur=mapperDTO.fromUtilisateurDTO(utilisateurDTO);
        Utilisateur utilisateurUpdate=utilisateurRepository.save(utilisateur);
        return mapperDTO.fromUtilisateur(utilisateurUpdate);
    }

    @Override
    public void deleteUtilisateur(Long id) throws UtilisateurNotFoundException {
        Utilisateur utilisateur= utilisateurRepository.findById(id)
                .orElseThrow(()->new UtilisateurNotFoundException("Cet id n'existe pas"));
        utilisateurRepository.delete(utilisateur);
    }

    @Override
    public List<UtilisateurDTO> rechercheUtilisateur(String keyword) {
        List<Utilisateur> utilisateurs=utilisateurRepository.rechercheUtilisateur(keyword);
       List<UtilisateurDTO> utilisateurDTOS=utilisateurs.stream().map(cust->mapperDTO.fromUtilisateur(cust)).collect(Collectors.toList());
        return utilisateurDTOS;
    }

    @Override
    public Utilisateur getUtilisateur(String username) {
        return this.utilisateurRepository.findByUsername(username);
    }
}
