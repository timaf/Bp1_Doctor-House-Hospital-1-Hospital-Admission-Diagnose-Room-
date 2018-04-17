package at.refugeescode.Administration.view;

import at.refugeescode.Administration.controller.HospitalAdmission;
import at.refugeescode.Administration.model.Patient;
import at.refugeescode.Administration.model.Symptoms;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping("/")
public class AdmissionController {

   private HospitalAdmission hospitalAdmission;

    public AdmissionController(HospitalAdmission hospitalAdmission) {
        this.hospitalAdmission = hospitalAdmission;
    }
    @ModelAttribute("patient")
    Patient patient(){
        return new Patient();
    }

    @ModelAttribute("symptomsList")
    List<String> symptomsList(){
        return Stream.of("fever","pain","vomit","dizziness","others").collect(Collectors.toList());
    }

    @GetMapping
    String page(){
       return "admission";
    }

   @PostMapping
    String post(Patient patient){
        hospitalAdmission.send(patient);
        return "redirect:/";
   }




}
