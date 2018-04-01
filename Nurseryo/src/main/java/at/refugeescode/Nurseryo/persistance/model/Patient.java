package at.refugeescode.Nurseryo.persistance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {

    @Id
    private String id;

    private int patientNumber;

    private String name;

    private String symptoms;

    private String illness;

    private String treatment;

    public Patient() {
    }

    public Patient(int patientNumber, String name, String symptoms, String illness) {
        this.patientNumber = patientNumber;
        this.name = name;
        this.symptoms = symptoms;
        this.illness = illness;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", patientNumber=" + patientNumber +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                ", illness='" + illness + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
