package com.sda;

public class TicTacToe {
    public static void main(String[] args) {
        Players p = new Players();
        Table board = new Table();
        char[][] table = board.getTable();

        boolean xTurn = true;


        for (int v = 0; v < 10; v++) {
            if (winner(table, v)) return;

            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    System.out.print(table[i][j]);
                }
                System.out.println();
            }

            int[] point = p.playerTurn();
            while (table[point[0]][point[1]] != '#') {
                System.out.println("Position is not empty");
                point = p.playerTurn();
            }
            if (xTurn) {
                board.updatePlayerX(point);
                xTurn = false;
            } else {
                board.updatePlayerO(point);
                xTurn = true;
            }

            if (winner(table, v)) return;
        }
    }

    private static boolean winner(char[][] table, int v) {
        if (v >= 4) {
            if ((table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == 'X') ||
                    (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == 'X') ||
                    (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][2] == 'X') ||

                    (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == 'X') ||
                    (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == 'X') ||
                    (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == 'X') ||

                    (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == 'X') ||
                    (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == 'X')) {
                System.out.println("Player X won!");
                return true;
            }
            if ((table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == 'O') ||
                    (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == 'O') ||
                    (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][2] == 'O') ||

                    (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == 'O') ||
                    (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == 'O') ||
                    (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == 'O') ||

                    (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == 'O') ||
                    (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == 'O')) {
                System.out.println("Player O won!");
                return true;
            } if (v == 9){
                System.out.println("Draw!");
                return true;
            }
        }
        return false;
    }
}
