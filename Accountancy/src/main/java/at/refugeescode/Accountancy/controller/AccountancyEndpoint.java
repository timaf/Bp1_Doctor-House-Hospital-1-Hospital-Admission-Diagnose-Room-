package at.refugeescode.Accountancy.controller;

import at.refugeescode.Accountancy.logic.TreatmentCost;
import at.refugeescode.Accountancy.persistence.model.Invoice;
import at.refugeescode.Accountancy.persistence.model.Patient;
import at.refugeescode.Accountancy.persistence.repository.AccountancyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class AccountancyEndpoint {

    private AccountancyRepository accountancyRepository;

    private TreatmentCost treatmentCost;

    public AccountancyEndpoint(AccountancyRepository accountancyRepository, TreatmentCost treatmentCost) {
        this.accountancyRepository = accountancyRepository;
        this.treatmentCost = treatmentCost;
    }
    @GetMapping
    Invoice[] bringAll(){
        List <Patient> patientList = accountancyRepository.findAll();
        List <Invoice> invoiceList = patientList.stream().map(patient -> {
            return patient.getInvoice();
        })
                .collect(Collectors.toList());
        System.out.println(invoiceList);
        return invoiceList.stream().toArray(Invoice[]::new);
    }


    @PostMapping
    Patient calculateCost(@RequestBody Patient patient){
        Patient accountancyPatient = treatmentCost.calculateCost(patient);
        accountancyRepository.save(accountancyPatient);
        return accountancyPatient;
    }

}
