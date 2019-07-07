import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

class Reception {
    private Hotel hotel;

    Reception(Hotel hotel) {
        this.hotel = hotel;
    }

    private void showMenu() {
        System.out.println("Choose key");
        System.out.println("1. To make a new reservation");
        System.out.println("2. To show all the reservations of the hotel");
        System.out.println("3. To print all reservations sorted by name");
        System.out.println("4. To close the application");
    }

    void checkIn() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int roomNr = random.nextInt(10);
        while (true) {
            showMenu();
            String key = scanner.next();

            switch (key) {
                case "1":
                    System.out.println("Type in your name");
                    String name = scanner.next();
                    System.out.println("Type the date for your reservation (yyyy-mm-dd)");
                    LocalDate date = LocalDate.parse(scanner.next());
                    while (!hotel.reserveRoom(date, name, roomNr)) {
                        roomNr = random.nextInt(10);
                    }
                    System.out.println("Room " + roomNr + 1 + " was reserved under " + name + " for date " + date);
                    break;

                case "2":
                    System.out.println(hotel.printAllReservations());
                    break;

                case "3":
                    System.out.println(hotel.sortReservations());
                    break;

                case "4":
                    hotel.save();
                    return;
            }
        }

    }


}
