package clinicProject.clinic;

import clinicProject.database.DatabaseAccess;
import clinicProject.entities.Doctor;
import clinicProject.entities.Patient;


public class Controller {
    public static void main(String[] args) {
        DatabaseAccess db = DatabaseAccess.getDBAccess();

        Doctor AlexCardio = new Doctor("Alex Ionescu", "cardiologie");
        Doctor MihaiStoma = new Doctor("Mihai Tampu", "stomatologie");
        Patient p1 = new Patient("Dimitriu Marius", "hipertensiune");
        Patient p2 = new Patient("Stefan Micu", "stenoza");
        Patient p3 = new Patient("Diana Dan", "gingivita");
        Patient p4 = new Patient("Stefania Voicu", "abces dentar");

        AlexCardio.addPatient(p1);
        AlexCardio.addPatient(p2);
        MihaiStoma.addPatient(p3);
        MihaiStoma.addPatient(p4);


        DatabaseAccess.closeClientConnection();
    }
}
