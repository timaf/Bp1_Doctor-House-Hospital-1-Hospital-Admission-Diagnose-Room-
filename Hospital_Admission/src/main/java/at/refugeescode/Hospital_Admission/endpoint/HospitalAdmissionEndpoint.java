package at.refugeescode.Hospital_Admission.endpoint;

import at.refugeescode.Hospital_Admission.logic.PatientsGenerator;
import at.refugeescode.Hospital_Admission.model.Patient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/patients")
public class HospitalAdmissionEndpoint {

    private RestTemplate restTemplate;
    private PatientsGenerator patientsGenerator ;

    public HospitalAdmissionEndpoint(RestTemplate restTemplate, PatientsGenerator patientsGenerator) {
        this.restTemplate = restTemplate;
        this.patientsGenerator = patientsGenerator;
    }

    @GetMapping
    Patient sendPatient() {
        List <Patient> patients = patientsGenerator.bringPatients();
        System.out.println("The patients are here .");
        String diagnoseUrl = "http://localhost:9002/patients";
        int patientNumber = new Random().nextInt(100);
        Collections.shuffle(patients);
        Patient patient = patients.get(0);
        patient.setPatientNumber(patientNumber);
        Patient patient1 = restTemplate.postForObject(diagnoseUrl, patient, Patient.class);
        System.out.println(patient1.toString());
        return patient1;
    }
}
