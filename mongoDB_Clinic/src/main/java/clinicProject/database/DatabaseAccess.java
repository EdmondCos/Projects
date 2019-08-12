package clinicProject.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseAccess {
    private MongoClient client;
    private MongoDatabase clinic;
    private MongoCollection<Document> doctors;
    private static DatabaseAccess db;

    private DatabaseAccess() {
        this.client = new MongoClient();
        this.clinic = client.getDatabase("clinic");
        this.doctors = clinic.getCollection("doctors");
    }

    public static DatabaseAccess getDBAccess() {
        if (db == null) {
            db = new DatabaseAccess();
        }
        return db;
    }

    public void saveDoctor(Document doctor) {
        if (contains(doctor) == null) {
            doctors.insertOne(doctor);
        } else {
            System.out.println("Doctor already registered!");
        }
    }

    private Document contains(Document doctor) {
        return doctors.find(new Document("name", doctor.getString("name"))).first();
    }


    public void update(String name, Document updated) {
        doctors.updateOne(new Document("name", name), new Document("$set", updated));
    }


//    public void printPatients() {
//        for (Document document : doctors.find(new Document())) {
//            System.out.println(document.get("pacienti"));
//        }
//    }
//
//    public void printDoctors() {
//        for (Document document : doctors.find(new Document())) {
//            System.out.println(document);
//        }
//    }

    public static void closeClientConnection() {
        db.client.close();
    }

}
