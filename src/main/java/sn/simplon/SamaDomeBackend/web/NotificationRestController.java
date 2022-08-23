package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.NotificationNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.NotificationDTO;
import sn.simplon.SamaDomeBackend.service.NotificationImplement;

import java.util.List;
@RestController
@CrossOrigin("*")
public class NotificationRestController {
    public NotificationImplement notificationService;

    public NotificationRestController(NotificationImplement notificationService) {this.notificationService = notificationService;}

    @GetMapping("/notifiactions")
    public List<NotificationDTO> getAll(){
        return notificationService.getAllNotification();
    }

    @GetMapping("/notifiaction/{id}")
    public NotificationDTO getOne(@PathVariable Long id) throws NotificationNotFoundException {
        return notificationService.getOneNotification(id);
    }
    @PostMapping("/notifiaction")
    public NotificationDTO save(@RequestBody NotificationDTO NotificationDTO) throws NotificationNotFoundException {
        return notificationService.saveNotification(NotificationDTO);
    }
    @PutMapping("/notifiaction/{id}")
    public NotificationDTO update(@PathVariable  Long id,@RequestBody NotificationDTO NotificationDTO){
        NotificationDTO.setId(id);
        return notificationService.updateNotification(NotificationDTO);
    }
    @DeleteMapping("/notifiaction/{id}")
    public void delete(@PathVariable Long id) throws NotificationNotFoundException {
        notificationService.deleteNotification(id);
    }
}
