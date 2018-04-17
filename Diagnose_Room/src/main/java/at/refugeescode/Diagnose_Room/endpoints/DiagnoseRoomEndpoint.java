package at.refugeescode.Diagnose_Room.endpoints;

import at.refugeescode.Diagnose_Room.logic.DrHouseDiagnose;
import at.refugeescode.Diagnose_Room.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class DiagnoseRoomEndpoint {

    private RestTemplate restTemplate;
    private DrHouseDiagnose drHouseDiagnose;

    @Value("${nursery.url}")
    private String nurseryUrl;

    public DiagnoseRoomEndpoint(RestTemplate restTemplate, DrHouseDiagnose drHouseDiagnose) {
        this.restTemplate = restTemplate;
        this.drHouseDiagnose = drHouseDiagnose;
    }

    @PostMapping
    Patient addPatient(@RequestBody Patient patient) {
        Patient diagnoseRoomPatient = drHouseDiagnose.diagnosePatient(patient);
        restTemplate.postForObject(nurseryUrl, diagnoseRoomPatient, Patient.class);
        return  diagnoseRoomPatient;

    }

}
