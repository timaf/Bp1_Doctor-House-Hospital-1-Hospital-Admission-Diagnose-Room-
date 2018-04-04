package at.refugeescode.Accountancy.persistence.repository;

import at.refugeescode.Accountancy.persistence.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountancyRepository extends JpaRepository<Patient, Long>{
}
