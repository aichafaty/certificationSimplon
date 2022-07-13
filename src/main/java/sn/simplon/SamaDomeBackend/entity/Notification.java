package sn.simplon.SamaDomeBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Notification {
    @Id
    private int id;
    private String sms;
    private String frequence;

}
