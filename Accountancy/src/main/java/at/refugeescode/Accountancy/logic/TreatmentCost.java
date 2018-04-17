package at.refugeescode.Accountancy.logic;

import at.refugeescode.Accountancy.persistence.model.Invoice;
import at.refugeescode.Accountancy.persistence.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

@Service
public class TreatmentCost {

    private Invoice invoice;

    @Value("#{'${recommendedTreatment}'.split(',')}")
    private List<String> treatments;

    @Value("#{'${prises}'.split(',')}")
    private List<String> prises;


    public Patient calculateCost(Patient patient){
        Map<String, String> accountMap = IntStream.range(0, treatments.size())
                .boxed()
                .collect(toMap(treatments::get, prises::get));

        double cost = Double.parseDouble(accountMap.get(patient.getTreatment()));

        invoice = new Invoice(patient.getName(), LocalDateTime.now(),cost);
        patient.setInvoice(invoice);
        return patient;
    }
}
