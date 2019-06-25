package com.sda;

public class Main {
    public static void main(String[] args) {
        Players players = new Players();
        TicTacToe ticTacToe = new TicTacToe(players);

        ticTacToe.playGame();
    }
}
