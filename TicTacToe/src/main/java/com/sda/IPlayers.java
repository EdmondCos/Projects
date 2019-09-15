package com.sda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IPlayers {
    int[] playerTurn(HttpServletRequest request, HttpServletResponse response);
}
