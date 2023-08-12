package project;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GenericServletExample extends GenericServlet {

    // ServletRequest = new HttpServletRequest()
    // ServletResponse = new HttpServletResponse()
    public void service(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String method = req.getMethod();
        if (method.equalsIgnoreCase("Get")) {
            doGet(req, res);
        } else if (method.equalsIgnoreCase("POST")) {
            doPost(req, res);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("Using GET Method inside Function");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("Using POST Method inside Function");
    }
}
