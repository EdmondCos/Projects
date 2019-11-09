package beans.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomServletGet extends HttpServlet {

    public CustomServletGet() {
        System.err.println("custom servlet eagerly initialized");
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nume = request.getParameter("nume");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World! " + CustomServletGet.class.getCanonicalName() + " with parameter 'name' " + nume + "</p>");

    }
}
