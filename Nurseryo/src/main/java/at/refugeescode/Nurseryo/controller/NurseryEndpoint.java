package at.refugeescode.Nurseryo.controller;

import at.refugeescode.Nurseryo.logic.PatientTreatment;
import at.refugeescode.Nurseryo.persistance.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/patients")
public class NurseryEndpoint {

    private RestTemplate restTemplate;

    private PatientTreatment patientTreatment;

    @Value("${accountancy.url}")
    private String accountancyUrl;

    public NurseryEndpoint(RestTemplate restTemplate, PatientTreatment patientTreatment) {
        this.restTemplate = restTemplate;
        this.patientTreatment = patientTreatment;
    }


    @PostMapping
     Patient nursePatient(@RequestBody Patient patient) {
        Patient nurseryPatient = patientTreatment.treatPatient(patient);
        restTemplate.postForObject(accountancyUrl, nurseryPatient, Patient.class);
        return nurseryPatient;
     }
}
