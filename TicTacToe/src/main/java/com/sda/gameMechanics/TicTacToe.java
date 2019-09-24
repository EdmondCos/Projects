package com.sda.gameMechanics;

import javax.servlet.http.HttpServletRequest;

public class TicTacToe {
    public static String info;

    private IPlayers players;
    private Board board;
    private String currentPlayer;
    private int gameOver;

    private TicTacToe() {
        info = " ";

        this.players = new Players();
        this.board = new Board();
        this.currentPlayer = "x";

    }

    private static TicTacToe start = new TicTacToe();

    public static TicTacToe getInstance() {
        return start;
    }


    public void playGame(HttpServletRequest request) {
        TicTacToe.getInstance();
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

    public void restart() {
        currentPlayer = "x";
        board = new Board();
    }
}

