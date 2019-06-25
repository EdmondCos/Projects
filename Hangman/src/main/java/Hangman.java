import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int counterLose = 0;
        int counterWin = 0;

        String[] library = {"masa", "casa", "para", "merisoare", "cangur",
                "dulceata", "telefon", "cablu", "patine", "noapte"};
        int rdm = random.nextInt(10);
        String[] cuvant = library[rdm].split("");
        String[] original = library[rdm].split("");
        String x = "_";

        for (int i = 1; i < cuvant.length - 1; i++) {
            cuvant[i] = "_";
        }

        while (counterLose != 5 && counterWin != cuvant.length - 2) {
            for (String i : cuvant) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println("Counter: " + counterLose + ". If counter reaches 5 you lose!");
            System.out.print("Guess a letter: ");
            String litera = scanner.next();
            System.out.println();

            boolean bol = true;
            for (int j = 1; j < cuvant.length - 1; j++) { //search
                if (litera.equals(original[j])) {
                    if (x.equals(cuvant[j])) {
                        cuvant[j] = litera;
                        bol = false;
                        counterWin++;
                        break;
                    }
                }
            }
            if (bol) {
                counterLose++;
            }
        }

        if (counterWin == cuvant.length - 2) {
            System.out.println(library[rdm] + " - You won!");
        } else {
            System.out.println(library[rdm] + " - You lost!");
        }
    }
}
