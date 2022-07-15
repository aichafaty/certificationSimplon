package sn.simplon.SamaDomeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.simplon.SamaDomeBackend.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
