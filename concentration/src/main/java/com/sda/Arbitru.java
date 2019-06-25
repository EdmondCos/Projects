package com.sda;

public class Arbitru {
    private IPlayable player;
    private Board board;

    public Arbitru(int size, IPlayable player) {
        this.board = new Board(size);
        this.player = player;
    }

    public void playGame() {
        while (!board.isGameOver()) {
            int[] c1 = player.getCoordonates();
            while (board.isRevealed(c1)) {
                System.out.println("Position was already guessed!");
                c1 = player.getCoordonates();
            }
            board.reveal(c1);
            System.out.println(board.toStrings());

            int[] c2 = player.getCoordonates();
            while (c2[0] == c1[0] && c2[1] == c1[1]) {
                System.out.println("Position not hidden!");
                c2 = player.getCoordonates();
            }
            while (board.isRevealed(c2)) {
                System.out.println("Position was already guessed!");
                c2 = player.getCoordonates();
            }
            board.reveal(c2);
            System.out.println(board.toStrings());

            if (!board.isMatch(c1, c2)) {
                board.hide(c1, c2);
            }
            System.out.println();
        }
    }
}
