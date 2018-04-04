package at.refugeescode.Nurseryo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NurseryoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurseryoApplication.class, args);
	}
}

/*Bp2 - Doctor House Hospital #2 (Nursery - NoSQL MongoDB, Accountancy -JPA MySQL)
		The Nursery app will have an endpoint called /patients and will receive them via post.
		A patient is expected to arrive with a patient number, a name, their list of symptoms and their diagnosed illness.
		Then the nurse will check their illness and provide the right treatment.Once that they have done this,
		the nurse will save this patient in their MongoDB database and finally forward the patient via post to the Accountancy app.
		The Accountancy app will receive the patient via post and for the given treatment, apply the specific costs,
		so that the accountant can create an invoice that the patient will have to pay in the future.

		The Accountancy app will store in its MySQL database the patients and also the invoices with the date they were created,
		the costs for the treatment and the patient they belong to.
		The Accountancy app will also have an endpoint /invoices that will show all the invoices generated sorted by creation date,
		so that in future Bps we will provide a user interface so the real accountant can see this in their computer.*/
