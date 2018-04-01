package at.refugeescode.Accountancy.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private int patientNumber;

    private String name;

    private String symptoms;

    private String illness;

    private String treatment;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Invoice> invoices = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set <Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set <Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientNumber=" + patientNumber +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                ", illness='" + illness + '\'' +
                ", treatment='" + treatment + '\'' +
                ", invoices=" + invoices +
                '}';
    }
}
