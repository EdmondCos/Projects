import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

class Hotel implements Serializable {
    private static final long serialVersionUID = 5470204499441826039L;
    private ArrayList<Room> rooms;

    private Hotel() {
        rooms = new ArrayList<>();
        addRooms();
    }

    private void addRooms() {
        for (int i = 1; i < 11; i++) {
            rooms.add(new Room(i));
        }
    }

    boolean reserveRoom(LocalDate date, String name, int roomNr) {
        return rooms.get(roomNr).makeValidReservation(date, name);
    }

    String printAllReservations() {
        StringBuilder x = new StringBuilder();
        for (Room r : rooms) {
            x.append(r.printRoomReservations()).append('\n');
        }
        return x.toString();
    }

    ArrayList<Reservation> sortReservations(){
        ArrayList<Reservation> res = new ArrayList<>();
        for(Room r : rooms){
            ArrayList<Reservation> temp = r.getAllReservations();
            res.addAll(temp);
        }
        res.sort(new Reservation.ComparatorByName().reversed());
        return res;
    }



    void save() {
        try {
            FileOutputStream file = new FileOutputStream("Reservations.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this);

            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Hotel load() {
        Hotel hotel;
        try {
            FileInputStream file = new FileInputStream("Reservations.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            hotel = (Hotel) in.readObject();

            in.close();
            file.close();

        } catch (ClassNotFoundException | IOException e) {
            return new Hotel();
        }
        return hotel;
    }
}
