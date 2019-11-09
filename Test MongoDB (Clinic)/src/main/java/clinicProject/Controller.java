package clinicProject;


import java.util.ArrayList;
import java.util.Scanner;

class Controller {
    void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Doctor> doctorList = new ArrayList<>();

        Doctor AlexCardio = new Doctor("Alex Ionescu", "cardiologie");
        doctorList.add(AlexCardio);
        Doctor MihaiStoma = new Doctor("Mihai Tampu", "stomatologie");
        doctorList.add(MihaiStoma);
        Doctor ElenaORL = new Doctor("Elena Damoc", "ORL");
        doctorList.add(ElenaORL);
        Doctor DanielOrto = new Doctor("Daniel Savu", "ortopedie");
        doctorList.add(DanielOrto);
        Doctor BiancaKids = new Doctor("Bianca Razvan", "pediatrie");
        doctorList.add(BiancaKids);

        System.out.println("Please enter your name");
        String name = scanner.nextLine();

        while (true) {
            int nr = -1;
            while (true) {
                System.out.println("Press 1 to register" + "\n" +
                        "Press 2 to delete your data" + "\n" +
                        "Press 3 to exit");
                nr = scanner.nextInt();
                if (nr > 0 && nr < 4) {
                    break;
                }
            }
            switch (nr) {
                case 1:
                    registerPatient(name, scanner, AlexCardio, MihaiStoma, ElenaORL, DanielOrto, BiancaKids);
                    break;
                case 2:
                    deletePatient(doctorList, name);
                    break;
                case 3:
                    DatabaseAccess.closeClientConnection();
                    return;
            }
        }
    }

    private void deletePatient(ArrayList<Doctor> doctorList, String name) {
        for (Doctor i : doctorList) {
            i.deletePatient(name);
        }
        System.out.println("Patient deleted from all records \n");
    }

    private void registerPatient(String name, Scanner scanner, Doctor alexCardio, Doctor mihaiStoma, Doctor elenaORL, Doctor danielOrto, Doctor biancaKids) {
        int nr;
        while (true) {
            System.out.println("Please select a doctor" + "\n" +
                    "Press 1 for cardiology" + "\n" +
                    "Press 2 for stomatology" + "\n" +
                    "Press 3 for ENT" + "\n" +
                    "Press 4 for orthopedy" + "\n" +
                    "Press 5 for pediatrics" + "\n" +
                    "etc.");

            nr = scanner.nextInt();
            scanner.nextLine();
            if (nr > 0 && nr < 6) {
                break;
            } else {
                System.out.println("Invalid Selection, please try again");
            }
        }
        System.out.println("Please enter your diagnostic");
        String diagnostic = scanner.nextLine();
        Patient patient = new Patient(name, diagnostic);

        switch (nr) {
            case 1:
                alexCardio.savePatient(patient);
                break;
            case 2:
                mihaiStoma.savePatient(patient);
                break;
            case 3:
                elenaORL.savePatient(patient);
                break;
            case 4:
                danielOrto.savePatient(patient);
                break;
            case 5:
                biancaKids.savePatient(patient);
                break;
        }
    }

}
