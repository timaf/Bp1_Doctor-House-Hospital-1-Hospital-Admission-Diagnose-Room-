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
    private Patient patient;
    private DrHouseDiagnose drHouseDiagnose;
    private List<Patient> patients = new ArrayList <>();

    public DiagnoseRoomEndpoint(RestTemplate restTemplate, Patient patient) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    List<Patient> receivePatient(){
        return patients;
    }
    @PostMapping
    Patient addPatient(@RequestBody Patient patient){
        patients.add(patient);
        Patient patient1 = drHouseDiagnose.diagnosePatient(patient);
        String nurseryUrl = "http://localhost:patients";
        Patient patient2 = restTemplate.postForObject(nurseryUrl, patient1, Patient.class);
        return patient2;
    }


}
