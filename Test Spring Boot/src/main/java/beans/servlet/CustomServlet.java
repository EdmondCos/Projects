package beans.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomServlet extends HttpServlet {

    public CustomServlet() {
        System.err.println("custom servlet eagerly initialized");
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World! GET custom servlet</p>");

    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World! POST custom servlet</p>");

    }

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getMethod();
        request.getSession();
        request.getParameterMap();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World! " + request.getMethod() + " custom servlet</p>");

    }

}
