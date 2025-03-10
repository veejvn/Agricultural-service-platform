package javaweb.my_project.repository;

import javaweb.my_project.entities.Account;
import javaweb.my_project.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, String> {
    Optional<Farmer> findByAccount(Account account);
}
