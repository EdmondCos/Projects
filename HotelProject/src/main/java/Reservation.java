import java.io.Serializable;
import java.time.LocalDate;

class Reservation implements Serializable {
    private LocalDate date;
    private String name;
    private int roomNr;

    Reservation(LocalDate date, String name, int roomNr) {
        this.date = date;
        this.name = name;
        this.roomNr = roomNr;
    }

    String printreservations() {
        return '\n' + "" + date + "/" + name;
    }
}
