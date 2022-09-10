package sn.simplon.SamaDomeBackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.UtilisateurNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.UtilisateurDTO;
import sn.simplon.SamaDomeBackend.entity.Utilisateur;
import sn.simplon.SamaDomeBackend.service.UtilisateurImplement;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UtilisateurRestController {
    @Autowired
    public UtilisateurImplement utilisateurService;


    public UtilisateurRestController(UtilisateurImplement utilisateurService) {this.utilisateurService = utilisateurService;}

    @GetMapping("/utilisateur")
    public List<UtilisateurDTO> getAll(){
        return utilisateurService.getAllUtilisateur();
    }

    @GetMapping("/utilisateur/reckerche")
    public List<UtilisateurDTO> rechercheUtilisateur(@RequestParam(name = "keyword",defaultValue ="" )String keyword ){
        return utilisateurService.rechercheUtilisateur("%" +keyword+ "%");
    }
    @GetMapping("/utilisateur/{id}")
    public UtilisateurDTO getOne(@PathVariable Long id) throws UtilisateurNotFoundException {
        return utilisateurService.getOneUtilisateur(id);
    }
    @PostMapping("/utilisateur")
    public UtilisateurDTO save(@RequestBody UtilisateurDTO UtilisateurDTO) throws UtilisateurNotFoundException {
        return utilisateurService.saveUtilisateur(UtilisateurDTO);
    }
    @PutMapping("/utilisateur/{id}")
    public UtilisateurDTO update(@PathVariable  Long id,@RequestBody UtilisateurDTO UtilisateurDTO){
        UtilisateurDTO.setId(id);
        return utilisateurService.updateUtilisateur(UtilisateurDTO);
    }
    @DeleteMapping("/utilisateur/{id}")
    public void delete(@PathVariable Long id) throws UtilisateurNotFoundException {
        utilisateurService.deleteUtilisateur(id);
    }

    @GetMapping("/utilisateurs/{username}")
    public Utilisateur getUsers(@PathVariable("username") String username) {
        return this.utilisateurService.getUtilisateur(username);
    }
}
