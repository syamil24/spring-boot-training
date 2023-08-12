package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestPrintServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String[] courses = request.getParameterValues("course"); // multiples values for
        // single parameter
        // Enumeration<String> paramNames = request.getParameterValues("courses");
        // //return
        // collection of names in a request
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("Name is" + name + "<br>");
        out.print("Courses " + courses + "<br>");
        out.print("</body></html>");
    }
}