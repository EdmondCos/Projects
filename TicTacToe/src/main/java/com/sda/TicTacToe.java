package com.sda;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TicTacToe")
public class TicTacToe extends HttpServlet {

    private IPlayers players = new Players();
    private Table table = new Table();
    private String currentPlayer = "x";


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String player = request.getParameter("player");
        if (!table.checkCurrentPlayer(currentPlayer, player)) {
            response.getWriter().append("Not the player at move!");
            return;
        }

        int[] coordonates = players.playerTurn(request);
        if (!table.isValidPosition(coordonates[0], coordonates[1])) {
            return;
        }

        table.updateTable(coordonates, player);

        if (table.isGameOver() == 1) {
            response.getWriter().append("Player X won!");
//            System.out.println("Player X won!");
            return;
        } else if (table.isGameOver() == 2) {
            response.getWriter().append("Player 0 won!");
//            System.out.println("Player 0 won!");
            return;
        } else if (table.isGameOver() == 3) {
            response.getWriter().append("Draw");
//            System.out.println("Draw");
            return;
        }

        if (currentPlayer.equals("x")) {
            currentPlayer = "0";
        } else {
            currentPlayer = "x";
        }

//        System.out.println(table.print());

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

