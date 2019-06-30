import java.time.LocalDate;

public class Reservation {
    LocalDate date;
    String name;
    int roomNr;

    public Reservation(LocalDate date, String name, int roomNr) {
        this.date = date;
        this.name = name;
        this.roomNr = roomNr;
    }

    @Override
    public boolean equals(Object x) {
        if (x instanceof Reservation) {
            Reservation tmp = (Reservation) x;
            return this.date.equals(tmp.date) && this.roomNr == tmp.roomNr;
        }
        return false;
    }

}
