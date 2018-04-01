package at.refugeescode.Diagnose_Room.logic;

import at.refugeescode.Diagnose_Room.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

@Service
public class DrHouseDiagnose {

// symptoms mostly are : fever,pain,vomit,dizziness,others
// illnesses mostly are :Flu,HeartDisease,Diabetes,Allergies,lupus

    @Value("#{'${illnesses}'.split(',')}")
    private List<String> illnesses ;

    @Value("#{'${symptoms}'.split(',')}")
    private List<String> symptoms ;

  public Patient  diagnosePatient(Patient patient){
      Map <String, String> medicalMap = IntStream.range(0, symptoms.size())
              .boxed()
              .collect(toMap(symptoms::get, illnesses::get));

      patient.setIllness(medicalMap.get(patient.getSymptoms()));

         System.out.println(patient.toString());

      return patient;
  }
}
