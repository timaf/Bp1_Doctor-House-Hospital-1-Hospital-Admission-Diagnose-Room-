package at.refugeescode.Diagnose_Room.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Patient {
    private int id;
    private String name;
    private List<String> symptoms = new ArrayList <>();
    private String illness;

    public Patient() {
    }

    public Patient(int id, String name, List <String> symptoms, String illness) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.illness = illness;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public List <String> getSymptoms() {
        return symptoms;
    }

    public String getIllness() {
        return illness;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptoms(List <String> symptoms) {
        this.symptoms = symptoms;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}
