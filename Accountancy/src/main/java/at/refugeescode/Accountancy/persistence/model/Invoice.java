package at.refugeescode.Accountancy.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private String patientName;

    private LocalDateTime date;

    private Double treatmentCost;

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public Invoice(String patientName, LocalDateTime date, Double treatmentCost) {
        this.patientName = patientName;
        this.date = date;
        this.treatmentCost = treatmentCost;
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
