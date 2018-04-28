package at.refugeescode.Administration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdministrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministrationApplication.class, args);
	}
}
/*Bp3 - Doctor House Hospital #3 (Administration UI)
		Provide an additional application called Administration that will have two web pages.
		One of them will be the index or home page under the “/” url,
		that will display a form so the patients can use it when they arrive to the hospital.
		In this page the patient can write his or her name and also the list of symptoms.
		When this form is submitted, the application will forward it to the HospitalAdmission application.
		the second page will take care of the invoices and it will be found under the “/invoices” url.
		There we will be able to see a table showing all the invoices that were created by the Accountancy application.
		As an additional feature, the Administration application will have a menu at the top of its pages
		(created as a fragment and inserted in these two pages) that allows us to easily
		navigate from and to the “admission” and “invoices” pages. As an additional challenge,
		the use of webjars or libraries like Bootstrap, Materialize Css or JQuery could be considered*/