package at.refugeescode.Nurseryo.persistance.repository;

import at.refugeescode.Nurseryo.persistance.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {

}
