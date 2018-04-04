package at.refugeescode.Accountancy.logic;

import at.refugeescode.Accountancy.persistence.model.Invoice;
import at.refugeescode.Accountancy.persistence.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class TreatmentCost {

    private Patient patient;

    final Double[] prises = {8020.90, 20.00, 160.30, 6.44, 00.00};

    public Invoice calculateCost(Patient patient){

        if(patient.getTreatment().contains("Surgery")) {
            return new Invoice(patient.getName(), LocalDateTime.now(), prises[0]);

        }
        else if(patient.getTreatment().contains("Tablets")) {
            return new Invoice(patient.getName(), LocalDateTime.now(), prises[1]);
        }
        else if(patient.getTreatment().contains("Injections")) {

            return new Invoice(patient.getName(), LocalDateTime.now(), prises[2]);
        }
        else if(patient.getTreatment().contains("Ointments")) {
            return new Invoice(patient.getName(), LocalDateTime.now(), prises[3]);
        }
        else {
            return new Invoice(patient.getName(), LocalDateTime.now(), prises[4]);
        }

    }
}
