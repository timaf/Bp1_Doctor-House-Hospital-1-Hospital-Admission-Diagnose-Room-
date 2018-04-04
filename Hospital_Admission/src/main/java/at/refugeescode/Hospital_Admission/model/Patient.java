package at.refugeescode.Hospital_Admission.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class Patient {

    private int patientNumber;
    private String name;
    private List<String> symptoms = new ArrayList <>();
    private String illness;

    public Patient() {
    }


    public Patient(int patientNumber, String name, List <String> symptoms, String illness) {
        this.patientNumber = patientNumber;
        this.name = name;
        this.symptoms = symptoms;
        this.illness = illness;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public String getName() {
        return name;
    }


    public List <String> getSymptoms() {
        return symptoms;
    }

    public String getIllness() {
        return illness;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptoms(List <String> symptoms) {
        this.symptoms = symptoms;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientNumber=" + patientNumber +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                ", illness='" + illness + '\'' +
                '}';
    }
}
