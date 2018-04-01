package at.refugeescode.Diagnose_Room.endpoints;

import at.refugeescode.Diagnose_Room.model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
public class DiagnoseRoomEndpoint {

    private RestTemplate restTemplate;

    public DiagnoseRoomEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    String sayHello(){
        return "HHHH";
    }
    @PostMapping
    Patient lookAt(@RequestBody Patient patient){
        return patient;

    }


}
