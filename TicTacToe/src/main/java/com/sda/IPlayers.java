package com.sda;

import javax.servlet.http.HttpServletRequest;

public interface IPlayers {
    int[] playerTurn(HttpServletRequest request);
}
