package at.refugeescode.Administration.controller;

import at.refugeescode.Administration.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Scope("session")
public class HospitalAdmission {

    private RestTemplate restTemplate;

    @Value("${admission.url}")
    private String admissionUrl;

    private String name;
    private String symptom;

    public HospitalAdmission(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void send(Patient patient){
        this.name = patient.getName();
        this.symptom = patient.getSymptom().toLowerCase();
        restTemplate.postForObject(admissionUrl, patient, Patient.class);
    }
}
