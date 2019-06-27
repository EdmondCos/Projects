
class Hangman {
    private IPlayer player;
    private Board board;

    Hangman(IPlayer player) {
        this.player = player;
        Library library = new Library();
        board = new Board(library.getRandomWord());
    }

    void playGame() {
        int x = 0;
        boolean bol = false;

        while (!board.isGameOver()) {
            System.out.println(board.print());
            char letter = player.guessLetter();

            while (board.isLetterRepeated(letter)) {
                System.out.println("You already tried this letter before!");
                letter = player.guessLetter();
            }

            bol = board.isMatch(letter);
            if (!bol) {
                x++;
            }
            System.out.println("Counter: " + x + ". If counter reaches 20 you lose!");
        }

        if (x == 5) {
            System.out.println("You lost!");
        } else {
            System.out.println("You won! - " + board.print());
        }
    }
}
