package at.refugeescode.Nurseryo.logic;

import at.refugeescode.Nurseryo.persistance.model.Patient;
import at.refugeescode.Nurseryo.persistance.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientTreatment {

    private PatientRepository patientRepository;

    @Value("#{'${recommendedTreatment}'.split(',')}")
    private List<String> treatments;

    public PatientTreatment(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient treatPatient(Patient patient) {
//        patient.setPatientNumber(patient.getPatientNumber());
//        patient.setName(patient.getName());
//        patient.setSymptoms(patient.getSymptoms());
//        patient.setIllness(patient.getIllness());
        if (patient.getIllness().equalsIgnoreCase("HeartDisease"))
            patient.setTreatment(treatments.get(0));
        else if (patient.getIllness().equalsIgnoreCase("Flu"))
            patient.setTreatment(treatments.get(1));
        else if (patient.getIllness().equalsIgnoreCase("Diabetes"))
            patient.setTreatment(treatments.get(2));
        else if (patient.getIllness().equalsIgnoreCase("Allergies"))
            patient.setTreatment(treatments.get(3));
        else
            patient.setTreatment(treatments.get(4));
        patientRepository.save(patient);
        return patient;
    }
}

