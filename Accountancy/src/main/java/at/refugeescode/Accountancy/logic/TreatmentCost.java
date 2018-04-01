package at.refugeescode.Accountancy.logic;

import at.refugeescode.Accountancy.persistence.model.Invoice;
import at.refugeescode.Accountancy.persistence.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class TreatmentCost {

    private Invoice invoice;

    final Double[] prises = {8020.90, 20.00, 160.30, 6.44, 00.00};

    public Patient calculateCost(Patient patient){
//        patient.setPatientNumber(patient.getPatientNumber());
//        patient.setName(patient.getName());
//        patient.setSymptoms(patient.getSymptoms());
//        patient.setIllness(patient.getIllness());
//        patient.setTreatment(patient.getTreatment());
        if(patient.getTreatment().equalsIgnoreCase("surgery")) {
             invoice = new Invoice(patient.getName(), LocalDateTime.now(), prises[0]);
        }
        else if(patient.getTreatment().equalsIgnoreCase("tablets")) {
             invoice = new Invoice(patient.getName(), LocalDateTime.now(), prises[1]);
        }
        else if(patient.getTreatment().equalsIgnoreCase("injections")) {
             invoice = new Invoice(patient.getName(), LocalDateTime.now(), prises[2]);
        }
        else if(patient.getTreatment().equalsIgnoreCase("ointments")) {
             invoice = new Invoice(patient.getName(), LocalDateTime.now(), prises[3]);
        }
        else {
             invoice = new Invoice(patient.getName(), LocalDateTime.now(), prises[4]);
        }
        Set <Invoice> invoices = patient.getInvoices();
        invoices.add(invoice);
        patient.setInvoices(invoices);
        return patient;
    }
}
