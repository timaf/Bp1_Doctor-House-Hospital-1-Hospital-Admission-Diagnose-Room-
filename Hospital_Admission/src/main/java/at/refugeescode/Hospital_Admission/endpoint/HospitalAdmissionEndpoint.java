package at.refugeescode.Hospital_Admission.endpoint;

import at.refugeescode.Hospital_Admission.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/patients")
public class HospitalAdmissionEndpoint {

    private RestTemplate restTemplate;
    private List <Patient> patients = new ArrayList<>();

    @Value("${diagnose.url}")
    private String diagnoseUrl;

    public HospitalAdmissionEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    List<Patient> welcome(){
        return patients;
    }

    @PostMapping
    Patient startPatient(@RequestBody Patient patient) {
        int patientNumber = new Random().nextInt(100);
        patient.setPatientNumber(patientNumber);
        patients.add(patient);
        restTemplate.postForObject(diagnoseUrl, patient, Patient.class);
        return patient;
    }
}
