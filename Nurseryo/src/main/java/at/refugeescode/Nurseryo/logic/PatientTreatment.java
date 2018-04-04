package at.refugeescode.Nurseryo.logic;

import at.refugeescode.Nurseryo.persistence.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientTreatment {

    private Patient patient;

    @Value("#{'${treatments}'.split(',')}")
    private List <String> treatments;

    public Patient treatPatient(Patient patient) {
        if (patient.getIllness().contains("HeartDisease"))
            patient.setTreatment(treatments.get(0));
        else if (patient.getIllness().contains("Flu"))
            patient.setTreatment(treatments.get(1));
        else if (patient.getIllness().contains("Diabetes"))
            patient.setTreatment(treatments.get(2));
        else if (patient.getIllness().contains("Allergies"))
            patient.setTreatment(treatments.get(3));
        else
            patient.setTreatment(treatments.get(4));
        return patient;
    }
}

