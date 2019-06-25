package com.sda;

public class TicTacToe {
    private IPlayers players;
    private Table table;

    public TicTacToe(IPlayers players) {
        this.players = players;
        this.table = new Table();
    }

    private boolean turnX = true;
    private boolean gameOn = true;

    public void playGame() {
        while (gameOn) {
            System.out.println();
            if (turnX) {
                System.out.println("Player X turn");
            } else {
                System.out.println("Player O turn");
            }
            int[] c = players.playerTurn();

            while (table.isNotEmpty(c)) {
                System.out.println("Position is not empty!");
                c = players.playerTurn();
            }

            if (turnX) {
                table.updateX(c);
                turnX = false;
            } else {
                table.updateO(c);
                turnX = true;
            }
            System.out.println(table.print());

            if (table.isGameOver() == 1) {
                System.out.println("Player X won!");
                gameOn = false;
            } else if (table.isGameOver() == 2) {
                System.out.println("Player O won!");
                gameOn = false;
            } else if (table.isGameOver() == 3) {
                System.out.println("Draw!");
                gameOn = false;
            }

        }
    }
}

