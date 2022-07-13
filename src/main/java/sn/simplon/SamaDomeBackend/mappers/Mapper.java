package sn.simplon.SamaDomeBackend.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.dtos.VaccinsDTO;
import sn.simplon.SamaDomeBackend.entity.Vaccins;

@Service
public class Mapper {
    //La methode qui transforme entite en entites dto
        public VaccinsDTO fromVaccins(Vaccins vaccins){
            VaccinsDTO vaccinsDTO=new VaccinsDTO();
            //Mais pour eviter les getters et setters on peux utiliser BeanUtils.propertis(objetatransformer,objetquitransforme)
            BeanUtils.copyProperties(vaccins,vaccinsDTO);
//            vaccinsDTO.setNomVaccin(vaccinsDTO.getNomVaccin());
//            vaccinsDTO.setEffetSecondaire(vaccinsDTO.getEffetSecondaire());
            return vaccinsDTO;
        }
        //La methode qui transforme entite dto en entite
        public Vaccins fromVaccinsDTO(VaccinsDTO vaccinsDTO){
            Vaccins vaccins=new Vaccins();
            BeanUtils.copyProperties(vaccinsDTO,vaccins);
            return vaccins;
        }

//        /*convertir entite departement en dto*/
//        public DepartementDTO fromDepartement(Departement departement){
//            DepartementDTO departementDTO=new DepartementDTO();
//            BeanUtils.copyProperties(departement,departementDTO);
//            return departementDTO;
//        }
//        /*Convertir entite departementDTO en entite departement*/
//        public Departement fromDepartementDTO(DepartementDTO departementDTO){
//            Departement departement=new Departement();
//            BeanUtils.copyProperties(departementDTO,departement);
//            return departement;
//        }
//
//        /*Convertir entite Administrateur en entite AdministrateurDTO*/
//        public AdministrateurDTO fromAdminstrateur(Administrateur administrateur){
//            AdministrateurDTO administrateurDTO=new AdministrateurDTO();
//            BeanUtils.copyProperties(administrateur,administrateurDTO);
//            administrateurDTO.setProfileDTO(fromProfile(administrateur.getProfile()));
//            administrateurDTO.setDepartementDTO(fromDepartement(administrateur.getDepartement()));
//            return administrateurDTO;
//        }
//        /*Convertir AdministrateurDTO en Administrateur*/
//        public Administrateur formAdministrateurDTO(AdministrateurDTO administrateurDTO){
//            Administrateur administrateur=new Administrateur();
//            BeanUtils.copyProperties(administrateurDTO,administrateur);
//            administrateur.setProfile(fromProfileDTO(administrateurDTO.getProfileDTO()));
//            administrateur.setDepartement(fromDepartementDTO(administrateurDTO.getDepartementDTO()));
//            return administrateur;
//        }
//        /*Convertir entite Etudiant en entite EtudiantDTO*/
//        public EtudiantDTO fromEtudiant(Etudiant etudiant){
//            EtudiantDTO etudiantDTO=new EtudiantDTO();
//            BeanUtils.copyProperties(etudiant,etudiantDTO);
//            etudiantDTO.setFiliereDTO(fromFiliere(etudiant.getFiliere()));
//            etudiantDTO.setProfileDTO(fromProfile(etudiant.getProfile()));
//            return etudiantDTO;
//        }
//        /*Convertir EtudiantDTO en Etudiant*/
//        public Etudiant fromEtudiantDTO(EtudiantDTO etudiantDTO){
//            Etudiant etudiant=new Etudiant();
//            BeanUtils.copyProperties(etudiantDTO,etudiant);
//            etudiant.setFiliere(fromFiliereDTO(etudiantDTO.getFiliereDTO()));
//            etudiant.setProfile(fromProfileDTO(etudiantDTO.getProfileDTO()));
//            return etudiant;
//        }
//        /*Convertir entite Filiere en entite FiliereDTO*/
//        public FiliereDTO fromFiliere(Filiere filiere){
//            FiliereDTO filiereDTO=new FiliereDTO();
//            BeanUtils.copyProperties(filiere,filiereDTO);
//            return filiereDTO;
//        }
//        /*Convertir entite FiliereDTO en entite Filere*/
//        public Filiere fromFiliereDTO(FiliereDTO filiereDTO){
//            Filiere filiere=new Filiere();
//            BeanUtils.copyProperties(filiereDTO,filiere);
//            return filiere;
//        }
//        /*Convertir entite Demande en entite DemandeDTO*/
//        public DemandeDTO fromDemande(Demande demande){
//            DemandeDTO demandeDTO=new DemandeDTO();
//            BeanUtils.copyProperties(demande,demandeDTO);
//            demandeDTO.setEtudiant(fromEtudiant(demande.getEtudiant()));
//            demandeDTO.setDepartement(fromDepartement(demande.getDepartement()));
//            return demandeDTO;
//        }
//        /*Convertir entite DemandeDTO en entite Demande*/
//        public Demande fromDemandeDTO(DemandeDTO demandeDTO){
//            Demande demande=new Demande();
//            BeanUtils.copyProperties(demandeDTO,demande);
//            demande.setEtudiant(fromEtudiantDTO(demandeDTO.getEtudiant()));
//            demande.setDepartement(fromDepartementDTO(demandeDTO.getDepartement()));
//            return demande;
//        }
    }

