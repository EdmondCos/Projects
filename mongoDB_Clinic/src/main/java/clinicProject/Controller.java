package clinicProject;


public class Controller {
    void run(){
        Doctor AlexCardio = new Doctor("Alex Ionescu", "cardiologie");
        Doctor MihaiStoma = new Doctor("Mihai Tampu", "stomatologie");

        Patient p1 = new Patient("Dimitriu Marius", "hipertensiune");
        Patient p2 = new Patient("Stefan Micu", "stenoza");
        Patient p3 = new Patient("Diana Dan", "gingivita");
        Patient p4 = new Patient("Stefania Voicu", "abces dentar");
        Patient p5 = new Patient("Ion Constantin", "hipotensiune");

        AlexCardio.addPatient(p1);
        AlexCardio.addPatient(p2);
        MihaiStoma.addPatient(p3);
        MihaiStoma.addPatient(p4);
        AlexCardio.addPatient(p5);

//        TODO:
//        Console UI selectare programare dr
//        Verificare disponibilitate programare in fct de data
//        Sterge programare in fct de nume
//        Afiseaza programarile in fct de nume

        DatabaseAccess.closeClientConnection();
    }
}
