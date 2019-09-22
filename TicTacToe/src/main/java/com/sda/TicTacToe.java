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
    private Board board = new Board();
    private String currentPlayer = "x";
    private int gameOver;
    public static String info = " ";


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        info = " ";

        String player = request.getParameter("player");
        if (board.checkCurrentPlayer(currentPlayer, player)) {

            int[] coordonates = players.playerTurn(request);
            if (board.isValidPosition(request, coordonates)) {
                board.updateTable(coordonates, player);

                gameOver = board.isGameOver(player);
                if (gameOver == 1) {
                    info = ("Player " + player + " won!");
                } else if (gameOver == 2) {
                    info = "Draw!";
                }

                if (currentPlayer.equals("x")) {
                    currentPlayer = "0";
                } else {
                    currentPlayer = "x";
                }
            }

        } else {
            info = "Not the player at move!";
        }

        if (gameOver != 3) {
            restart();
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    void restart() {
        currentPlayer = "x";
        board = new Board();
    }
}

