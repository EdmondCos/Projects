package clinicProject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.lang.reflect.Array;
import java.util.ArrayList;

class DatabaseAccess {
    private static DatabaseAccess db;

    private MongoClient client;
    private MongoDatabase clinic;
    private MongoCollection<Document> doctors;

    private DatabaseAccess() {
        this.client = new MongoClient();
        this.clinic = client.getDatabase("clinic");
        this.doctors = clinic.getCollection("doctors");
    }

    //    singleton pattern, making sure we have only 1 connection open
    static DatabaseAccess getDBAccess() {
        if (db == null) {
            db = new DatabaseAccess();
        }
        return db;
    }

    ArrayList<String> existingPatients(String name) {
        ArrayList x;
        try {
            x = (ArrayList) doctors.find(new Document("name", name)).first().get("patients");
        } catch (java.lang.NullPointerException e) {
            return new ArrayList<>();
        }
        return x;
    }

    void saveDoctor(Document doctor) {
        if (contains(doctor) == null) {
            doctors.insertOne(doctor);
        }
    }

    private Document contains(Document doctor) {
        return doctors.find(new Document("name", doctor.getString("name"))).first();
    }


    void updatePatientList(String drName, Document updated) {
        doctors.updateOne(new Document("name", drName), new Document("$set", updated));
    }

    ArrayList<String> removePatient(String patientName, Document dr) {
        ArrayList<String> patients = (ArrayList) dr.get("patients");
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).toLowerCase().contains(patientName.toLowerCase())) {
                patients.remove(i--);
            }
        }
        Document newPatient = new Document("$set", new Document("patients", patients));
        doctors.updateOne(new Document("name", dr.getString("name")), newPatient);
        return patients;
    }


    static void closeClientConnection() {
        db.client.close();
    }

}
