package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInitParams extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String name = getServletConfig().getInitParameter("defaultName");
        String color = getServletContext().getInitParameter("backgroundColor");

        PrintWriter out = response.getWriter();
        response.getWriter().print("Name is " + name + "Color is " + color);
        ;

        out.print("Color from servlet context is " + color);
    }

}
