package com.sda;

class Table {

    private EChars[][] table;
    private EChars[] chars = EChars.values();
    private int rounds = 0;

    Table() {
        table = new EChars[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = chars[0];
            }
        }
    }

    boolean isNotEmpty(int[] c) {
        return !table[c[0]][c[1]].equals(chars[0]);
    }

    void updateX(int[] c) {
        table[c[0]][c[1]] = chars[1];
        rounds++;
    }

    void updateO(int[] c) {
        table[c[0]][c[1]] = chars[2];
        rounds++;
    }

    boolean isGameOver() {
        if (rounds >= 4) {
            if ((table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == chars[1]) ||
                    (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == chars[1]) ||
                    (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][2] == chars[1]) ||

                    (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == chars[1]) ||
                    (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == chars[1]) ||
                    (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == chars[1]) ||

                    (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == chars[1]) ||
                    (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == chars[1])) {
                System.out.println("Player X won!");
                return true;
            } else if ((table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == chars[2]) ||
                    (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == chars[2]) ||
                    (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][2] == chars[2]) ||

                    (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == chars[2]) ||
                    (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == chars[2]) ||
                    (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == chars[2]) ||

                    (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == chars[2]) ||
                    (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == chars[2])) {
                System.out.println("Player O won!");
                return true;
            } else if (rounds == 9) {
                System.out.println("Draw!");
                return true;
            }
        }
        return false;
    }

    String print() {
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                x.append(table[i][j]);
            }
            x.append('\n');
        }
        return x.toString();
    }
}
