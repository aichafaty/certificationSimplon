package sn.simplon.SamaDomeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.simplon.SamaDomeBackend.entity.Carnet;

public interface CarnetRepository extends JpaRepository<Carnet,Long> {
}
