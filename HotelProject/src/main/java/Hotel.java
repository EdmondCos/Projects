import java.time.LocalDate;
import java.util.ArrayList;

class Hotel {
    private ArrayList<Room> rooms = new ArrayList<>();

    Hotel() {
        addRooms();
    }

    private void addRooms() {
        for (int i = 1; i < 11; i++) {
            rooms.add(new Room(i));
        }
    }

    boolean reserveRoom(LocalDate date, String name, int roomNr) {
        boolean bol = rooms.get(roomNr - 1).isValidReservation(date, name);
        if (!bol) {
            return false;
        } else {
            rooms.get(roomNr - 1).makeReservation();
            return true;
        }
    }
}
