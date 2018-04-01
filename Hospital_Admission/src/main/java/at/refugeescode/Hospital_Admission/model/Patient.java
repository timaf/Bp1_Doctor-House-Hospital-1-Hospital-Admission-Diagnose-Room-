package at.refugeescode.Hospital_Admission.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Patient {
    private UUID id;
    private String name;
    private List<String> symptoms = new ArrayList <>();
    private String ilness;

    public Patient() {
    }

    public Patient(UUID id, String name, List <String> symptoms, String ilness) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.ilness = ilness;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public List <String> getSymptoms() {
        return symptoms;
    }

    public String getIlness() {
        return ilness;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptoms(List <String> symptoms) {
        this.symptoms = symptoms;
    }

    public void setIlness(String ilness) {
        this.ilness = ilness;
    }
}
