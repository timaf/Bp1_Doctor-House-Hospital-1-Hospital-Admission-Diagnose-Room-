package at.refugeescode.Nurseryo.logic;

import at.refugeescode.Nurseryo.persistance.model.Patient;
import at.refugeescode.Nurseryo.persistance.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

@Service
public class PatientTreatment {

    private PatientRepository patientRepository;

    @Value("#{'${illnesses}'.split(',')}")
    private List<String> illnesses ;

    @Value("#{'${recommendedTreatment}'.split(',')}")
    private List<String> treatments;

    public PatientTreatment(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient treatPatient(Patient patient) {
        Map<String, String> treatmentMap = IntStream.range(0, illnesses.size())
                .boxed()
                .collect(toMap(illnesses::get, treatments::get));

        patient.setTreatment(treatmentMap.get(patient.getIllness()));
        patientRepository.save(patient);
        return patient;
    }
}

