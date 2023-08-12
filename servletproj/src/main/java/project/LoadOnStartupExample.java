package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadOnStartupExample extends HttpServlet {

    public LoadOnStartupExample() {
        System.out.println("Load On Startup Object Created");
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        System.out.println("destroy method called on load on startup servlet");
    }

}
