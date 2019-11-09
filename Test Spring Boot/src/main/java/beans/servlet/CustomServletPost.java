package beans.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomServletPost extends HttpServlet {

    public CustomServletPost() {
        System.err.println("custom servlet eagerly initialized");
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nume = (String) request.getAttribute("nume");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World! " + CustomServletPost.class.getCanonicalName() + " with parameter 'name' " + nume + "</p>");

    }
}
