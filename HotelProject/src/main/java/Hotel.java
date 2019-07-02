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
        return rooms.get(roomNr - 1).isValidReservation(date, name);
    }

}
