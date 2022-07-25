package sn.simplon.SamaDomeBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.simplon.SamaDomeBackend.entity.Utilisateur;

@Data @AllArgsConstructor @NoArgsConstructor
public class NotificationDTO {
    private Long id;
    private String sms;
    private String frequence;
    private Utilisateur utilisateur;
}
