package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        if (name == null) {
            ServletConfig config = getServletConfig();
            name = config.getInitParameter("defaultName");
        }
        System.out.println("Do Get Method in HttpServletExample called");

        PrintWriter out = response.getWriter();
        out.print("Welcome" + name);
        out.print("<hr>");

        ServletContext context = getServletContext();
        String color = context.getInitParameter("backgroundColor");

        out.print("Color from servlet context is " + color);
    }

}
