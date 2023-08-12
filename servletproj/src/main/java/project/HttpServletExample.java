package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletExample extends HttpServlet {
    public static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // String[] courses = request.getParameter("course"); //multiples values for
        // single parameter
        // Enumeration<String> paramNames = request.getParamenterNames() //return
        // collection of names in a request
        System.out.println("Do Get Method in HttpServletExample called");
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Do Post Method in HttpServletExample called");
    }
}
