package at.refugeescode.Diagnose_Room.logic;

import at.refugeescode.Diagnose_Room.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrHouseDiagnose {

    private Patient patient;

    @Value("#{'${illnesses}'.split(',')}")
    private List<String> illnesses ;

  public Patient  diagnosePatient(Patient patient){
      if(patient.getSymptoms().contains("fever"))
          patient.setIllness(illnesses.get(0));
      else if (patient.getSymptoms().contains("dizziness"))
          patient.setIllness(illnesses.get(1));
      else if (patient.getSymptoms().contains("pain"))
          patient.setIllness(illnesses.get(2));
      else if (patient.getSymptoms().contains("dizziness"))
          patient.setIllness(illnesses.get(3));
      else
          patient.setIllness("Lupus");
      return patient;
  }
}
