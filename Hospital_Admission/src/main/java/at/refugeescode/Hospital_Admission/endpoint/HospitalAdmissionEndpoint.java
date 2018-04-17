package at.refugeescode.Hospital_Admission.endpoint;

import at.refugeescode.Hospital_Admission.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping("/patients")
public class HospitalAdmissionEndpoint {

    private RestTemplate restTemplate;

    @Value("${diagnose.url}")
    private String diagnoseUrl;

    public HospitalAdmissionEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    Patient startPatient(@RequestBody Patient patient) {
        int patientNumber = new Random().nextInt(100);
        patient.setPatientNumber(patientNumber);
        restTemplate.postForObject(diagnoseUrl, patient, Patient.class);
        System.out.println(patient);
        System.out.println("gggggg");
        return patient;
    }
}
