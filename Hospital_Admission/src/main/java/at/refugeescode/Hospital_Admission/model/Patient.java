package at.refugeescode.Hospital_Admission.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {

    private int patientNumber;
    private String name;
    private String symptoms;

    public Patient() {
    }

    public Patient(int patientNumber, String name, String symptoms) {
        patientNumber = 0;
        this.name = name;
        this.symptoms = symptoms;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientNumber=" + patientNumber +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                 '\'' +
                '}';
    }
}
