package clinicProject;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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


    void updatePatientList(String name, Document updated) {
        doctors.updateOne(new Document("name", name), new Document("$set", updated));
    }

    void removePatient(String patientName, Document dr){
        BasicDBObject query = new BasicDBObject();

    }


//    void printPatients() {
//        for (Document document : doctors.find(new Document())) {
//            System.out.println(document.get("patients"));
//        }
//    }
//
//    void printDoctors() {
//        for (Document document : doctors.find(new Document())) {
//            System.out.println(document);
//        }
//    }

    static void closeClientConnection() {
        db.client.close();
    }

}
