import java.util.Random;

class Library {
    private String[] library = {"masa", "casa", "para", "merisoare", "cangur",
            "dulceata", "telefon", "cablu", "patine", "noapte"};
    private Random random = new Random();

    String getRandomWord() {
        return library[random.nextInt(library.length)];
    }

}
