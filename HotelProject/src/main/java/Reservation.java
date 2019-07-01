import java.time.LocalDate;

class Reservation {
    private LocalDate date;
    private String name;
    private int roomNr;

    Reservation(LocalDate date, String name, int roomNr) {
        this.date = date;
        this.name = name;
        this.roomNr = roomNr;
    }

    boolean isReserved(Reservation x) {
        return x.date.equals(date) && x.roomNr == roomNr;
    }


}
