package com.sda.gameMechanics;

import javax.servlet.http.HttpServletRequest;

class Players implements IPlayers {

    public int[] playerTurn(HttpServletRequest request) {
        int[] coord = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (request.getParameter("L" + i + "C" + j) != null) {
                    coord[0] = i;
                    coord[1] = j;
                    return coord;
                }
            }
        }
        return null;
    }

}

