package at.refugeescode.Administration.model;

public class Patient {

    private int patientNumber;
    private String name;
    private String symptoms;


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
        this.patientNumber = 0;
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
