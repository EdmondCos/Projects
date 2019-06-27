import java.util.Scanner;

public class Player implements IPlayer {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public char guessLetter() {
        System.out.print("Guess a letter: ");
        return scanner.next().charAt(0);
    }
}
