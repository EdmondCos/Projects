package com.sda;

import java.util.Scanner;

public class Player implements IPlayable {
    private Scanner scanner = new Scanner(System.in);

    public int[] getCoordonates() {
        System.out.print("Select row 1-4: ");
        int row = scanner.nextByte() - 1;
        System.out.print("Select column 1-4: ");
        int column = scanner.nextByte() - 1;
        System.out.println();
        return new int[]{row, column};
    }
}
