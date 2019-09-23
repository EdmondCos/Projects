package com.sda.servlets;

import com.sda.gameMechanics.TicTacToe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Reset")
public class Reset extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TicTacToe.restart();
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
