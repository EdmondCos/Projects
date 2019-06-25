package com.sda;

import java.util.Random;

class Board {
    private Piece[][] matrix;
    private int emptySpace;

    Board(int size) {
        matrix = new Piece[size][size];
        ESymbols[] symbolArray = ESymbols.values();
        emptySpace = size * size;

        for (int i = 0; i < symbolArray.length; i++) {
            for (int j = 0; j < 2; j++) {
                Random random = new Random();

                int k = random.nextInt(4);
                int l = random.nextInt(4);
                if (matrix[k][l] == null) {
                    matrix[k][l] = new Piece(symbolArray[i]);
                } else {
                    j--;
                }
            }
        }
    }

    void reveal(int[] coordonates) {
        matrix[coordonates[0]][coordonates[1]].hide = false;
        emptySpace--;
    }

    boolean isRevealed(int[] c) {
        return !matrix[c[0]][c[1]].hide;
    }

    boolean isMatch(int[] c1, int[] c2) {
        return matrix[c1[0]][c1[1]].symbol == matrix[c2[0]][c2[1]].symbol;
    }

    void hide(int[] c1, int[] c2) {
        matrix[c1[0]][c1[1]].hide = true;
        matrix[c2[0]][c2[1]].hide = true;
        emptySpace = emptySpace + 2;
    }

    boolean isGameOver() {
        return emptySpace == 0;
    }

    String toStrings() {
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].hide) {
                    x.append("0");
                } else {
                    x.append(matrix[i][j].symbol);
                }
            }
            x.append('\n');
        }
        return x.toString();
    }
}
