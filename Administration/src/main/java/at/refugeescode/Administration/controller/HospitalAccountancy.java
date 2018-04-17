package at.refugeescode.Administration.controller;

import at.refugeescode.Administration.model.Invoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Scope("session")
public class HospitalAccountancy {

    private RestTemplate restTemplate;

    @Value("${accountancy.url}")
    private String accountancyUrl;

    public HospitalAccountancy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Invoice> bringInvoices(){
        Invoice[] allInvoices = restTemplate.getForObject(accountancyUrl, Invoice[].class);
        return Stream.of(allInvoices).collect(Collectors.toList());

    }
}