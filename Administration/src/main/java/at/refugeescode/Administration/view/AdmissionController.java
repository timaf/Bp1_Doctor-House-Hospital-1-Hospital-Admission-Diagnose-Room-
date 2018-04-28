package at.refugeescode.Administration.view;

import at.refugeescode.Administration.controller.HospitalAdmission;
import at.refugeescode.Administration.model.Patient;
import at.refugeescode.Administration.model.Symptoms;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@Scope("session")
public class AdmissionController {

   private HospitalAdmission hospitalAdmission;

    public AdmissionController(HospitalAdmission hospitalAdmission) {
        this.hospitalAdmission = hospitalAdmission;
    }
    @ModelAttribute("patient")
    Patient patient(){
        return new Patient();
    }

    @ModelAttribute("symptoms")
    Symptoms[] symptoms(){
        return Symptoms.values();
    }

    @GetMapping
    String page(){
       return "admission";
    }

   @PostMapping
    String post(Patient patient){
       return "redirect:/";
   }




}
