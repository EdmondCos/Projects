package com.sda.servlets;

import com.sda.gameMechanics.TicTacToe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PlayGame")
public class PlayGame extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TicTacToe.playGame(request);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
