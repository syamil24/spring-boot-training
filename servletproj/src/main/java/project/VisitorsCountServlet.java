package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitorsCountServlet extends HttpServlet {

    int getCount = 0;
    int postCount = 0;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        getCount++;
        System.out.println("Do Get Method in HttpServletExample called");

        PrintWriter out = response.getWriter();
        out.print("Total Visitors" + getCount);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println("Do Get Method in HttpServletExample called");
        postCount++;
        PrintWriter out = response.getWriter();
        out.print("Total Visitors" + postCount);
        out.print("<hr>");
        doGet(request, response);
    }

}
