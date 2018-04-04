package at.refugeescode.Diagnose_Room.endpoints;

import at.refugeescode.Diagnose_Room.logic.DrHouseDiagnose;
import at.refugeescode.Diagnose_Room.model.Patient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class DiagnoseRoomEndpoint {

    private RestTemplate restTemplate;
    private DrHouseDiagnose drHouseDiagnose;
    private List <Patient> patients = new ArrayList <>();
    private Patient patient;
    public DiagnoseRoomEndpoint(RestTemplate restTemplate, Patient patient) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    List <Patient> receivePatient() {
        return patients;
    }

    @PostMapping
    Patient addPatient(@RequestBody Patient patient) {
        patients.add(patient);
       /* patient = drHouseDiagnose.diagnosePatient(patient);
        String nurseryUrl = "http://localhost:9003/patients";
        patient = restTemplate.postForObject(nurseryUrl, patient, Patient.class);*/
        return  patient;
    }

}
