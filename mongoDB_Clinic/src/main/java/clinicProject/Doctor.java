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
        this.patients = arrayList();
        DB.saveDoctor(doctor());
    }

    private ArrayList<String> arrayList() {
        if (DB == null) {
            return new ArrayList<>();
        } else {
            return DB.getExistingPatients(name);
        }
    }

    private Document doctor() {
        doctor = new Document("name", name).
                append("expertise", expertise).
                append("patients", patients);
        return doctor;
    }

    void addPatient(Patient patient) {
        if (!patients.contains(patient.toJSON())) {
            patients.add(patient.toJSON());
            doctor = new Document("name", name).
                    append("expertise", expertise).
                    append("patients", patients);
            DB.updatePatientList(name, doctor);
        }
    }
}

