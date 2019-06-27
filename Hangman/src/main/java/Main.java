public class Main {
    public static void main(String[] args) {
        IPlayer player = new Player();
        Hangman hangman = new Hangman(player);
        hangman.playGame();
    }
}
