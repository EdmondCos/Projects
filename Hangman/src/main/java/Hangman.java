
public class Hangman {
    private IPlayer player;
    private Board board;

    Hangman(IPlayer player) {
        this.player = player;
        board = new Board("cuvant");
    }

    public void playGame() {
        int x = 0;
        while (!board.isGameOver()) {
            System.out.println(board.print());
            x = board.leterReveal(player.guessLetter());
            System.out.println("Counter: " + x + ". If counter reaches 5 you lose!");
        }
        if (x == 5) {
            System.out.println("You lost!");
        } else {
            System.out.println("You won! - " + board.print());
        }
    }
}
