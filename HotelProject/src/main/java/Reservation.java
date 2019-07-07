import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

class Reservation implements Serializable {
    private static final long serialVersionUID = 7501428922258636142L;
    private LocalDate date;
    private String name;
    private int roomNr;

    Reservation(LocalDate date, String name, int roomNr) {
        this.date = date;
        this.name = name;
        this.roomNr = roomNr;
    }

    public static class ComparatorByName implements Comparator<Reservation> {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    @Override
    public String toString() {
        return "Room:" + roomNr + "/" + date + "/" + name;
    }
}

