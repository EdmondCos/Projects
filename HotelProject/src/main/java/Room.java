import java.time.LocalDate;
import java.util.ArrayList;

public class Room {
    ArrayList<Reservation> reservations;
    int roomNr;

    Room(int roomNr) {
        this.roomNr = roomNr;
    }

    public boolean isReserved(LocalDate date, String name) {
        Reservation x = new Reservation(date, name, roomNr);
        if (reservations.equals(x)) {
            return false;
        }
        reservations.add(x);
        return true;
    }
}
