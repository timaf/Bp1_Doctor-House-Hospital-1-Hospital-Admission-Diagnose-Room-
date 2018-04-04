package at.refugeescode.Nurseryo.persistence.repository;

import at.refugeescode.Nurseryo.persistence.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NurseryRepository extends MongoRepository<Patient, String> {
}
