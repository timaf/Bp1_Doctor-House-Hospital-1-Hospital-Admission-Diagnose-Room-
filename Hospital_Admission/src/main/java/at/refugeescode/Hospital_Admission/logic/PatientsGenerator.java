package at.refugeescode.Hospital_Admission.logic;

import at.refugeescode.Hospital_Admission.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientsGenerator {

    @Value("#{'${Symptoms}'.split(',')}")
    private List<String> allSymptoms;

    @Value("#{'${patients.names}'.split(',')}")
    private List<String> patientsNames;

    public List<Patient> bringPatients(){
        return patientsNames.stream()
                .map(name -> new Patient(0,name, sayYourSymptoms(), "unknown"))
                .collect(Collectors.toList());
    }

    private List<String> sayYourSymptoms(){
        Collections.shuffle(allSymptoms);
        return allSymptoms.stream()
                .limit(2)
                .collect(Collectors.toList());
    }

}
