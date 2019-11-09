package com.sda.gameMechanics;

import javax.servlet.http.HttpServletRequest;

public class Board {
    private int rounds;

    public static String L0C0 = "_";
    public static String L0C1 = "_";
    public static String L0C2 = "_";

    public static String L1C0 = "_";
    public static String L1C1 = "_";
    public static String L1C2 = "_";

    public static String L2C0 = "_";
    public static String L2C1 = "_";
    public static String L2C2 = "_";

    public Board() {
        rounds = 0;

        L0C0 = "_";
        L0C1 = "_";
        L0C2 = "_";

        L1C0 = "_";
        L1C1 = "_";
        L1C2 = "_";

        L2C0 = "_";
        L2C1 = "_";
        L2C2 = "_";
    }


    boolean checkCurrentPlayer(String currentPlayer, String player) {
        return currentPlayer.equals(player);
    }


    boolean isValidPosition(HttpServletRequest request, int[] i) {
        return "_".equals(request.getParameter("L" + i[0] + "C" + i[1]));
    }

    void updateTable(int[] c, String player) {
        rounds++;

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

    int isGameOver(String player) {
        if (rounds >= 4) {
            if ((L0C0.equals(L1C1) && L1C1.equals(L2C2) && L0C0.equals(player)) || (L0C2.equals(L1C1) && L1C1.equals(L2C0) && L0C2.equals(player)) ||

                    (L0C0.equals(L0C1) && L0C1.equals(L0C2) && L0C0.equals(player)) ||
                    (L1C0.equals(L1C1) && L1C1.equals(L1C2) && L1C0.equals(player)) ||
                    (L2C0.equals(L2C1) && L2C1.equals(L2C2) && L2C0.equals(player)) ||

                    (L0C0.equals(L1C0) && L1C0.equals(L2C0) && L0C0.equals(player)) ||
                    (L0C1.equals(L1C1) && L1C1.equals(L2C1) && L0C1.equals(player)) ||
                    (L0C2.equals(L1C2) && L1C2.equals(L2C2) && L0C2.equals(player))) {
                return 1;
            } else if (rounds >= 9) {
                return 2;
            }
        }
        return 3;
    }
}
