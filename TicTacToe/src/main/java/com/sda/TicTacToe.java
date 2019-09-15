package com.sda;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TicTacToe extends HttpServlet {

    private IPlayers players = new Players();
    private Table table = new Table();
    private String currentPlayer = "x";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append('\n' + "Was player ").append(currentPlayer).append(" turn!" + '\n');

        int[] coordonates = players.playerTurn(request, response);
        if (!table.isValidPosition(coordonates[0], coordonates[1])) {
            response.getWriter().append("Position is either occupied or outside the board!");
            response.getWriter().append(table.print());
            return;
        }

        table.updateTable(coordonates, currentPlayer);
        response.getWriter().append(table.print());

        if (table.isGameOver() == 1) {
            response.getWriter().append("Player X won!");
            return;
        } else if (table.isGameOver() == 2) {
            response.getWriter().append("Player 0 won!");
            return;
        } else if (table.isGameOver() == 3) {
            response.getWriter().append("Draw");
            return;
        }

        if (currentPlayer.equals("x")) {
            currentPlayer = "0";
        } else {
            currentPlayer = "x";
        }
        response.getWriter().append('\n' + "Player ").append(currentPlayer).append(" turn!" + '\n');
    }
}

