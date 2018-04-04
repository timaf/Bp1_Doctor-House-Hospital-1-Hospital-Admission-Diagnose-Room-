package at.refugeescode.Accountancy.controller;

import at.refugeescode.Accountancy.logic.TreatmentCost;
import at.refugeescode.Accountancy.persistence.model.Invoice;
import at.refugeescode.Accountancy.persistence.model.Patient;
import at.refugeescode.Accountancy.persistence.repository.AccountancyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class AccountancyEndpoint {

    private List<Patient> patients;

    private Patient accountancyPatient;

    private TreatmentCost treatmentCost;

    private AccountancyRepository accountancyRepo;

    @GetMapping("/patients")

    String welcomeAccountancy(){
        return " welcome accountancy";
    }

    @PostMapping("/patients")
    Patient calculateCost(@RequestBody Patient patient){
        accountancyPatient.setPatientNumber(patient.getPatientNumber());
        accountancyPatient.setName(patient.getName());
        accountancyPatient.setSymptoms(patient.getSymptoms());
        accountancyPatient.setIllness(patient.getIllness());
        accountancyPatient.setTreatment(patient.getTreatment());
        Invoice invoice = treatmentCost.calculateCost(accountancyPatient);
        Set <Invoice> invoices = accountancyPatient.getInvoices();
        invoices.add(invoice);
        accountancyPatient.setInvoices(invoices);
        accountancyRepo.save(accountancyPatient);
        return accountancyPatient;
    }

}
