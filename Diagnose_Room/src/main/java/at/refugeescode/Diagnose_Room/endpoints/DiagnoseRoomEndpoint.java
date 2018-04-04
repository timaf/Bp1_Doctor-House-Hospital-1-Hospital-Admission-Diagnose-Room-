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


    public DiagnoseRoomEndpoint(RestTemplate restTemplate, DrHouseDiagnose drHouseDiagnose) {
        this.restTemplate = restTemplate;
        this.drHouseDiagnose = drHouseDiagnose;
    }

    @GetMapping
    List <Patient> receivePatient() {
        return patients;
    }

    @PostMapping
    Patient addPatient(@RequestBody Patient patient) {
        Patient diagnoseRoomPatient = drHouseDiagnose.diagnosePatient(patient);
        patients.add(diagnoseRoomPatient);
        String nurseryUrl = "http://localhost:9003/patients";
        patient = restTemplate.postForObject(nurseryUrl, diagnoseRoomPatient, Patient.class);
        return  diagnoseRoomPatient;

    }

}
