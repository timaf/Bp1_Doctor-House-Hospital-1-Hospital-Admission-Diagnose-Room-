package at.refugeescode.Administration.view;

import at.refugeescode.Administration.controller.HospitalAccountancy;
import at.refugeescode.Administration.model.Invoice;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoices")
@Scope("session")
public class InvoiceController {

    private HospitalAccountancy hospitalAccountancy;

    public InvoiceController(HospitalAccountancy hospitalAccountancy) {
        this.hospitalAccountancy = hospitalAccountancy;
    }

    @ModelAttribute("invoices")
    List<Invoice> invoices() {
        return hospitalAccountancy.bringInvoices();
    }

    @GetMapping
    String page(){
        return "invoices";
    }
}
