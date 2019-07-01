import java.time.LocalDate;
import java.util.ArrayList;

class Room {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private int roomNr;
    Reservation x;

    Room(int roomNr) {
        this.roomNr = roomNr;
    }

    boolean isValidReservation(LocalDate date, String name) {
        x = new Reservation(date, name, roomNr);
        for (Reservation r : reservations) {
            if (r.isReserved(x)) {
                return false;
            }
        }
        return true;
    }

    void makeReservation() {
        reservations.add(x);
    }

}
