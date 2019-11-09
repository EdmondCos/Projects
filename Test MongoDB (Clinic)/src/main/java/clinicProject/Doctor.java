package clinicProject;

import org.bson.Document;

import java.util.ArrayList;

class Doctor {

    private final DatabaseAccess DB = DatabaseAccess.getDBAccess();

    private String name;
    private String expertise;
    private ArrayList<String> patients;
    private Document doctor;


    Doctor(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
        this.patients = DB.existingPatients(name);
        DB.saveDoctor(doctor());
    }


    private Document doctor() {
        doctor = new Document("name", name).
                append("expertise", expertise).
                append("patients", patients);
        return doctor;
    }

    void deletePatient(String name) {
        patients = DB.removePatient(name, doctor);
    }

    void savePatient(Patient patient) {
        if (!patients.contains(patient.toJSON())) {
            patients.add(patient.toJSON());
            doctor = new Document("name", name).
                    append("expertise", expertise).
                    append("patients", patients);
            DB.updatePatientList(name, doctor);
            System.out.println("Patient saved");
            return;
        }
        System.out.println("Patient already registered");
    }
}

