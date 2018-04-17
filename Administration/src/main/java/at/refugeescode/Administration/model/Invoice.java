package at.refugeescode.Administration.model;

import java.time.LocalDateTime;


public class Invoice {

    private Long id;

    private String patientName;

    private LocalDateTime date;

    private Double treatmentCost;

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(Double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", date=" + date +
                ", treatmentCost=" + treatmentCost +
                '}';
    }
}
