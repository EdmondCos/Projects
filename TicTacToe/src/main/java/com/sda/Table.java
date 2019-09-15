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

    boolean isValidPosition(int line, int column) {
        if ((column < 0) || (column > 2)) {
            return false;
        } else if ((line < 0) || (line > 2)) {
            return false;
        }
        return chars[0].equals(table[line][column]);
    }

    void updateTable(int[] c, String player) {
        if (player.equals("x")) {
            table[c[0]][c[1]] = chars[1];
            rounds++;
        } else {
            table[c[0]][c[1]] = chars[2];
            rounds++;
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

    String print() {
        StringBuilder x = new StringBuilder();
        x.append('\n');
        for (EChars[] eChars : table) {
            for (int j = 0; j < table.length; j++) {
                x.append(eChars[j]).append(" ");
            }
            x.append('\n');
        }
        return x.toString();
    }
}
