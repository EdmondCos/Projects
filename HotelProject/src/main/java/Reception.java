import java.time.LocalDate;
import java.util.Scanner;

class Reception {
    private Hotel hotel;
    private Scanner scanner = new Scanner(System.in);

    Reception(){
        hotel = new Hotel();
    }

    void checkIn() {
        System.out.println("Please enter your name.");
        String name = scanner.next();
        System.out.println("Please select a room 1-10.");
        int roomNr = scanner.nextInt();

        while (true) {
            System.out.println("Please choose the date of your staying. (yyyy-mm-dd)");
            String x = scanner.next();
            LocalDate date = LocalDate.parse(x);

            while (!hotel.reserveRoom(date, name, roomNr)) {
                System.out.println("Room " + roomNr + " is already reserved on this date." + '\n' +
                        "Please make another selection!");
                x = scanner.next();
                date = LocalDate.parse(x);
            }
            System.out.println("Room " + roomNr + " is now reserved under name " + name + " for date " + date);

            System.out.println("Press 1 if you want to select more days.");
            System.out.println("Press any key if you want to finish your reservation.");
            if (!scanner.next().equals("1")) {
                break;
            }
        }
    }
}
