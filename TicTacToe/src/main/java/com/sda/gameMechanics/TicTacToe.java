package com.sda.gameMechanics;
import javax.servlet.http.HttpServletRequest;

public class TicTacToe {
    public static String info = " ";

    private static IPlayers players = new Players();
    private static Board board = new Board();
    private static String currentPlayer = "x";
    private static int gameOver;


    public static void playGame(HttpServletRequest request){
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
    }

    public static void restart() {
        currentPlayer = "x";
        board = new Board();
    }
}

