package com.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Reset")
public class Reset extends HttpServlet {
    private TicTacToe ticTacToe = new TicTacToe();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ticTacToe.restart();
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
