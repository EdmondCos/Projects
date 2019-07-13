import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

class Room implements Serializable {
    private static final long serialVersionUID = 6094585800702734024L;
    private TreeSet<Reservation> reservations;
    private int roomNr;

    Room(int roomNr) {
        this.roomNr = roomNr;
        reservations = new TreeSet<>();
    }

    boolean makeValidReservation(LocalDate date, String name) {
        Reservation x = new Reservation(date, name, roomNr);
        return reservations.add(x);
    }

    String printRoomReservations() {
        StringBuilder x = new StringBuilder();
        for (Reservation r : reservations) {
            x.append(r);
        }
        return x.toString();
    }

    ArrayList<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }
}
