package at.refugeescode.Nurseryo.logic;

import at.refugeescode.Nurseryo.persistance.model.Patient;
import at.refugeescode.Nurseryo.persistance.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PatientTreatmentTest {

    @Autowired
    private PatientTreatment treatment;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void treatPatient() {
        Patient patient = new Patient();
        patient.setName("Sarah");
        patient.setIllness("HeartDisease");

        treatment.treatPatient(patient);

        Example <Patient> example = Example.of(patient);
        Optional <Patient> oPatient = patientRepository.findOne(example);

        assertTrue(oPatient.isPresent());
        assertEquals("surgery", oPatient.get().getTreatment());
    }
}