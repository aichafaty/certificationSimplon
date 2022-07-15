package sn.simplon.SamaDomeBackend.service;

import sn.simplon.SamaDomeBackend.Exception.NotificationNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.NotificationDTO;

import java.util.List;

public interface NotificationService {
    NotificationDTO saveNotification(NotificationDTO vaccinationDTO) throws NotificationNotFoundException;
    List<NotificationDTO> getAllNotification();
    NotificationDTO getOneNotification(Long id) throws NotificationNotFoundException;
    NotificationDTO updateNotification(NotificationDTO vaccinationDTO);
    void deleteNotification(Long id) throws NotificationNotFoundException;
}
