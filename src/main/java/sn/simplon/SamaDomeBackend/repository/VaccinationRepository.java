package sn.simplon.SamaDomeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.simplon.SamaDomeBackend.entity.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination,String> {
}
