import java.time.LocalDate;
import java.util.ArrayList;

class Room {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private int roomNr;

    Room(int roomNr) {
        this.roomNr = roomNr;
    }

    boolean isValidReservation(LocalDate date, String name) {
        Reservation x = new Reservation(date, name, roomNr);
        for (Reservation r : reservations) {
            if (r.isReserved(x)) {
                return false;
            }
        }
        reservations.add(x);
        return true;
    }
}
