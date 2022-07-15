package sn.simplon.SamaDomeBackend.web;

import org.springframework.web.bind.annotation.*;
import sn.simplon.SamaDomeBackend.Exception.NotificationNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.NotificationDTO;
import sn.simplon.SamaDomeBackend.service.NotificationImplement;

import java.util.List;
@RestController
public class NotificationRestController {
    public NotificationImplement rvService;

    public NotificationRestController(NotificationImplement rvService) {this.rvService = rvService;}

    @GetMapping("/notifiaction")
    public List<NotificationDTO> getAll(){
        return rvService.getAllNotification();
    }

    @GetMapping("/notifiaction/{id}")
    public NotificationDTO getOne(@PathVariable Long id) throws NotificationNotFoundException {
        return rvService.getOneNotification(id);
    }
    @PostMapping("/notifiaction")
    public NotificationDTO save(@RequestBody NotificationDTO NotificationDTO) throws NotificationNotFoundException {
        return rvService.saveNotification(NotificationDTO);
    }
    @PutMapping("/notifiaction/{id}")
    public NotificationDTO update(@PathVariable  Long id,@RequestBody NotificationDTO NotificationDTO){
        NotificationDTO.setId(id);
        return rvService.updateNotification(NotificationDTO);
    }
    @DeleteMapping("/notifiaction/{id}")
    public void delete(Long id) throws NotificationNotFoundException {
        rvService.deleteNotification(id);
    }
}
