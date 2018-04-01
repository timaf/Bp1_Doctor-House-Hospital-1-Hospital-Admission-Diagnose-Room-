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
    List<Patient> getAll() {
        List <Patient> patients = patientsGenerator.bringPatients();
        System.out.println("The patients are here .");
        return patients;
    }


    @PostMapping
    Patient sendPatient(@RequestBody Patient patient){
        List <Patient> patients = patientsGenerator.bringPatients();
        String diagnoseUrl = "http://localhost:9002/patients";
        int id = new Random().nextInt(100);
        Collections.shuffle(patients);
        Patient patient1 = patients.get(0);
        patient1.setId(id);
        patient = restTemplate.postForObject(diagnoseUrl, patient1, Patient.class);
        return patient;
    }





}
