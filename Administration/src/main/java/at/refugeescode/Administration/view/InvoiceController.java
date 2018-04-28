package at.refugeescode.Administration.view;

import at.refugeescode.Administration.model.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @GetMapping
    String page(){
        return "invoices";
    }


}
