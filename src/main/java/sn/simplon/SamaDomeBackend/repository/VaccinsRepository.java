package sn.simplon.SamaDomeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.simplon.SamaDomeBackend.entity.Vaccins;

public interface VaccinsRepository extends JpaRepository<Vaccins,Long> {
}
