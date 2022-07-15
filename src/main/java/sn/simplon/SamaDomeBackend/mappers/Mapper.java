package sn.simplon.SamaDomeBackend.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.dtos.*;
import sn.simplon.SamaDomeBackend.entity.*;

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

        /*convertir entite maladie en dto*/
        public MaladiesDTO fromMaladies(Maladies maladies){
            MaladiesDTO maladiesDTO=new MaladiesDTO();
            BeanUtils.copyProperties(maladies,maladiesDTO);
            return maladiesDTO;
        }
      /*Convertir entite maladiesDTO en entite maladie*/
        public Maladies fromMaladiesDTO(MaladiesDTO maladiesDTO){
            Maladies maladies=new Maladies();
            BeanUtils.copyProperties(maladiesDTO,maladies);
            return maladies;
        }
        /*convertir entite vaccination en dto*/
        public VaccinationDTO fromVaccination(Vaccination vaccination){
            VaccinationDTO vaccinationDTO=new VaccinationDTO();
            BeanUtils.copyProperties(vaccination,vaccinationDTO);

            return vaccinationDTO;
        }
        /*Convertir entite vaccinationDTO en entite vaccination*/
        public Vaccination fromVaccinationDTO(VaccinationDTO vaccinationDTO){
            Vaccination  vaccination=new Vaccination();
            BeanUtils.copyProperties(vaccinationDTO,vaccination);
            return vaccination;
        }

    /*convertir entite carnet en dto*/
    public CarnetDTO fromCarnet(Carnet carnet){
        CarnetDTO carnetDTO=new CarnetDTO();
        BeanUtils.copyProperties(carnet,carnetDTO);

        return carnetDTO;
    }
    /*Convertir entite carnetDTO en entite carnet*/
    public Carnet fromCarnetDTO(CarnetDTO carnetDTO){
        Carnet carnet=new Carnet();
        BeanUtils.copyProperties(carnetDTO,carnet);
        return carnet;
    }


    /*convertir entite rv en dto*/
    public RvDTO fromRv(Rv rv){
        RvDTO rvDTO=new RvDTO();
        BeanUtils.copyProperties(rv,rvDTO);

        return rvDTO;
    }
    /*Convertir entite rvDTO en entite rv*/
    public Rv fromRvDTO(RvDTO rvDTO){
        Rv rv=new Rv();
        BeanUtils.copyProperties(rvDTO,rv);
        return rv;
    }


    /*convertir entite notification en dto*/
    public NotificationDTO fromNotification(Notification notification){
        NotificationDTO notificationDTO=new NotificationDTO();
        BeanUtils.copyProperties(notification,notificationDTO);

        return notificationDTO;
    }
    /*Convertir entite notificationDTO en entite notification*/
    public Notification fromNotificationDTO(NotificationDTO NotificationDTO){
        Notification notification=new Notification();
        BeanUtils.copyProperties(NotificationDTO,notification);
        return notification;
    }



    /*convertir entitie roles en dto*/
    public RolesDTO fromRoles(Roles roles){
        RolesDTO rolesDTO=new RolesDTO();
        BeanUtils.copyProperties(roles,rolesDTO);
        return rolesDTO;
    }
    /*Convertir entite rolesDTO en entite roles*/
    public Roles fromRolesDTO(RolesDTO rolesDTO){
        Roles roles = new Roles();
        BeanUtils.copyProperties(rolesDTO,roles);
        return roles;
    }

    /*convertir entitie roles en dto*/
    public UtilisateurDTO fromUtilisateur(Utilisateur utilisateur){
        UtilisateurDTO utilisateurDTO=new UtilisateurDTO();
        BeanUtils.copyProperties(utilisateur,utilisateurDTO);
        return utilisateurDTO;
    }
    /*Convertir entite rolesDTO en entite roles*/
    public Utilisateur fromUtilisateurDTO(UtilisateurDTO utilisateurDTO){
        Utilisateur utilisateur = new Utilisateur();
        BeanUtils.copyProperties(utilisateurDTO,utilisateur);
        return utilisateur;
    }



}

