package com.sda;

import java.util.Scanner;

class Players implements IPlayers{
    private Scanner scanner = new Scanner(System.in);

    public int[] playerTurn() {
        System.out.println("Select a row 1-3: ");
        int line = scanner.nextInt() - 1;
        System.out.println("Select a column 1-3: ");
        int row = scanner.nextInt() - 1;
        return new int[]{line, row};
    }
}

