package at.refugeescode.Administration.controller;

import at.refugeescode.Administration.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HospitalAdmission {

    private RestTemplate restTemplate;

    @Value("${admission.url}")
    private String admissionUrl;

    private String name;
    private String symptoms;

    public HospitalAdmission(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void send(Patient patient){
        this.name = patient.getName();
        this.symptoms = patient.getSymptoms();
        Patient patient1 = restTemplate.postForObject(admissionUrl, patient, Patient.class);
        System.out.println(patient);
        System.out.println("bbbbbbb");
    }
}
