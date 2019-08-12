package clinicProject.entities;

import clinicProject.database.DatabaseAccess;
import org.bson.Document;

import java.util.ArrayList;

public class Doctor {

    private final DatabaseAccess DB = DatabaseAccess.getDBAccess();

    private String name;
    private String expertise;
    private ArrayList<String> patients;
    private Document doctor;


    public Doctor(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
        this.patients = new ArrayList<>();
        DB.saveDoctor(doctor());
    }

    private Document doctor() {
        doctor = new Document("name", name).
                append("expertise", expertise).
                append("patients", patients);
        return doctor;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient.toJSON());
            doctor = new Document("name", name).
                    append("expertise", expertise).
                    append("patients", patients);
            DB.update(name, doctor);
        } else {
            System.out.println("Patient already registered!");
        }
    }
}

