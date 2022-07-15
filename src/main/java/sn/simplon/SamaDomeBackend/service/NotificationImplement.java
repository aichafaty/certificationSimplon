package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.NotificationNotFoundException;

import sn.simplon.SamaDomeBackend.dtos.NotificationDTO;

import sn.simplon.SamaDomeBackend.entity.Notification;
import sn.simplon.SamaDomeBackend.mappers.Mapper;

import sn.simplon.SamaDomeBackend.repository.NotificationRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class NotificationImplement implements NotificationService{
    private NotificationRepository notificationRepository;
    private Mapper mapperDTO;
    
    @Override
    public NotificationDTO saveNotification(NotificationDTO notificationDTO) throws NotificationNotFoundException {
         Notification notification =mapperDTO.fromNotificationDTO(notificationDTO);
        Notification notificationSave=notificationRepository.save(notification);
        return mapperDTO.fromNotification(notificationSave);
    }

    @Override
    public List<NotificationDTO> getAllNotification() {
        List<Notification> notificationList= notificationRepository.findAll();
        List<NotificationDTO> notificationDTOS=notificationList.stream()
                .map(rv-> mapperDTO.fromNotification(rv))
                .collect(Collectors.toList());
        return notificationDTOS;
    }

    @Override
    public NotificationDTO getOneNotification(Long id) throws NotificationNotFoundException {
        Notification notification= notificationRepository.findById(id)
                .orElseThrow(()->new NotificationNotFoundException("Cet notification n'existe pas"));
        return mapperDTO.fromNotification(notification);
    }

    @Override
    public NotificationDTO updateNotification(NotificationDTO notificationDTO) {
        Notification notification=mapperDTO.fromNotificationDTO(notificationDTO);
        Notification notificationUpdate=notificationRepository.save(notification);
        return mapperDTO.fromNotification(notificationUpdate);
    }

    @Override
    public void deleteNotification(Long id) throws NotificationNotFoundException {
        Notification rv= notificationRepository.findById(id)
                .orElseThrow(()->new NotificationNotFoundException("Cet id n'existe pas"));
        notificationRepository.delete(rv);
    }
}
