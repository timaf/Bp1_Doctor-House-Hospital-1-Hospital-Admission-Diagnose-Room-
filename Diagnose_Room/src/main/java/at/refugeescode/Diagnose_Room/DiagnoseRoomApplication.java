package at.refugeescode.Diagnose_Room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiagnoseRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagnoseRoomApplication.class, args);
	}
}

/*Bp1 - Doctor House Hospital #1 (Hospital Admission, Diagnose Room)
		The Hospital Admission is an app that receives Patients through the /patients endpoint.
		 As soon as they arrive they get a patient number given and they are forwarded to the Diagnose Room.
		  The Dr House will observe the Patient’s symptoms and figure out his illness ,
		  and if he is unsure, he will quickly estimate that it must be lupus. Later on,
		   after the 4 Bps are concluded, the Dr House will forward the Patient with his right diagnosis to the Nurser*/
