package at.refugeescode.Nurseryo.controller;

import at.refugeescode.Nurseryo.logic.PatientTreatment;
import at.refugeescode.Nurseryo.persistence.model.Patient;
import at.refugeescode.Nurseryo.persistence.repository.NurseryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class NurseryEndpoint {

    private NurseryRepository nurseryRepo;

    private RestTemplate restTemplate;

    @Autowired
    private PatientTreatment patientTreatment;

    private List<Patient> patients;

    private Patient nurseryPatient;

    public NurseryEndpoint() {
    }

    public NurseryEndpoint(NurseryRepository nurseryRepo, RestTemplate restTemplate, Patient patient) {
        this.nurseryRepo = nurseryRepo;
        this.restTemplate = restTemplate;
        this.nurseryPatient = patient;
    }

    @GetMapping
    String welcomeNursery(){
        return "Welcome in our nursery ";
    }

    @PostMapping
    Patient nursePatient(@RequestBody Patient patient) {

        Patient nurseryPatient = new Patient();
        nurseryPatient.setPatientNumber(patient.getPatientNumber());
        nurseryPatient.setName(patient.getName());
        nurseryPatient.setSymptoms(patient.getSymptoms());
        nurseryPatient.setIllness(patient.getIllness());
        nurseryPatient.setTreatment((patientTreatment.treatPatient(nurseryPatient)).getTreatment());
        patients.add(nurseryPatient);
        nurseryRepo.save(nurseryPatient);
        String accountancyUrl = "http://localhost:9004/patients";
        patient = restTemplate.postForObject(accountancyUrl, nurseryPatient, Patient.class);
        return nurseryPatient;
    }
}
