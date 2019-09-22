package com.sda;

public class Table {
    private EChars[][] table;
    private EChars[] chars = EChars.values();
    private int rounds = 0;

    private static String L0C0 = " ";
    private static String L0C1 = " ";
    private static String L0C2 = " ";

    private static String L1C0 = " ";
    private static String L1C1 = " ";
    private static String L1C2 = " ";

    private static String L2C0 = " ";
    private static String L2C1 = " ";
    private static String L2C2 = " ";

    public static String getL0C0() {
        return L0C0;
    }

    public static String getL0C1() {
        return L0C1;
    }

    public static String getL0C2() {
        return L0C2;
    }

    public static String getL1C0() {
        return L1C0;
    }

    public static String getL1C1() {
        return L1C1;
    }

    public static String getL1C2() {
        return L1C2;
    }

    public static String getL2C0() {
        return L2C0;
    }

    public static String getL2C1() {
        return L2C1;
    }

    public static String getL2C2() {
        return L2C2;
    }

    Table() {
        table = new EChars[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = chars[0];
            }
        }
    }

    boolean isValidPosition(int line, int column) {
        if ((column < 0) || (column > 2)) {
            return false;
        } else if ((line < 0) || (line > 2)) {
            return false;
        }
        return chars[0].equals(table[line][column]);
    }

    boolean checkCurrentPlayer(String currentPlayer, String player) {
        return currentPlayer.equals(player);
    }

    void updateTable(int[] c, String player) {
        if (player.equals("x")) {
            table[c[0]][c[1]] = chars[1];
            rounds++;
        } else {
            table[c[0]][c[1]] = chars[2];
            rounds++;
        }

        if (c[0] == 0) {
            if (c[1] == 0) {
                L0C0 = player;
            } else if (c[1] == 1) {
                L0C1 = player;
            } else {
                L0C2 = player;
            }
        } else if (c[0] == 1) {
            if (c[1] == 0) {
                L1C0 = player;
            } else if (c[1] == 1) {
                L1C1 = player;
            } else {
                L1C2 = player;
            }
        } else {
            if (c[1] == 0) {
                L2C0 = player;
            } else if (c[1] == 1) {
                L2C1 = player;
            } else {
                L2C2 = player;
            }
        }
    }

    int isGameOver() {
        if (rounds >= 4) {
            if ((table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == chars[1]) ||
                    (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == chars[1]) ||
                    (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][2] == chars[1]) ||

                    (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == chars[1]) ||
                    (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == chars[1]) ||
                    (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == chars[1]) ||

                    (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == chars[1]) ||
                    (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == chars[1])) {
                return 1;
            } else if ((table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == chars[2]) ||
                    (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == chars[2]) ||
                    (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][2] == chars[2]) ||

                    (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == chars[2]) ||
                    (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == chars[2]) ||
                    (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == chars[2]) ||

                    (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == chars[2]) ||
                    (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == chars[2])) {
                return 2;
            } else if (rounds == 9) {
                return 3;
            }
        }
        return 4;
    }

//    String print() {
//        StringBuilder x = new StringBuilder();
//        x.append('\n');
//        for (EChars[] eChars : table) {
//            for (int j = 0; j < table.length; j++) {
//                x.append(eChars[j]).append(" ");
//            }
//            x.append('\n');
//        }
//        return x.toString();
//    }
}
