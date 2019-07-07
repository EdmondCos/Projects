import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

class Room implements Serializable {
    private static final long serialVersionUID = 6094585800702734024L;
    private ArrayList<Reservation> reservations;
    private int roomNr;

    Room(int roomNr) {
        this.roomNr = roomNr;
        reservations = new ArrayList<>();
    }

    boolean makeValidReservation(LocalDate date, String name) {
        Reservation x = new Reservation(date, name, roomNr);
        if (reservations.contains(x)) {
            return false;
        } else {
            reservations.add(x);
            return true;
        }
    }

    String printRoomReservations() {
        StringBuilder x = new StringBuilder();
        for (Reservation r : reservations) {
            x.append(r);
        }
        return x.toString();
    }

    ArrayList<Reservation> getAllReservations(){
        return reservations;
    }
}
