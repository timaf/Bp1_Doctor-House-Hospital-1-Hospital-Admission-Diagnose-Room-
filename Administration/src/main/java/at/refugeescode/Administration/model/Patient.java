package at.refugeescode.Administration.model;

public class Patient {

    private int patientNumber;
    private String name;
    private String symptom;

    public Patient() {
    }

    public Patient(int patientNumber, String name, String symptom) {
        patientNumber = 0;
        this.name = name;
        this.symptom = symptom;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientNumber=" + patientNumber +
                ", name='" + name + '\'' +
                ", symptoms=" + symptom +
                 '\'' +
                '}';
    }
}
