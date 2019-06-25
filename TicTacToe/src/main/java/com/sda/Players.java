package com.sda;

import java.util.Scanner;

class Players {
    private Scanner scanner = new Scanner(System.in);
    boolean turnX = true;

    int[] playerTurn() {
        System.out.println();
        if (turnX) {
            System.out.println("Player X turn");
            turnX = false;
        } else {
            System.out.println("Player O turn");
            turnX = true;
        }

        System.out.println("Select a row 1-3");
        int line = scanner.nextInt() - 1;
        System.out.println("Select a column 1-3");
        int row = scanner.nextInt() - 1;
        return new int[]{line, row};
    }
}

