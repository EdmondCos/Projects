package com.sda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Players implements IPlayers {

    public int[] playerTurn(HttpServletRequest request, HttpServletResponse response) {
        int line = Integer.valueOf(request.getParameter("line"));
        int column = Integer.valueOf(request.getParameter("column"));
        return new int[]{line, column};
    }


}

