package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericWelcomeServlet extends GenericServlet {

    public GenericWelcomeServlet() {
        super();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");

        String user = req.getParameter("name");

        PrintWriter out = res.getWriter();
        out.print("<html><body>");
        out.print("<b>hello simple servlet</b>");
        out.print("<b>hello" + user + "</b>");
        out.print("</body></html>");

    }
}
