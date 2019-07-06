public class Main {
    public static void main(String[] args) {

        Reception reception = new Reception(Hotel.load());
        reception.checkIn();

    }
}
