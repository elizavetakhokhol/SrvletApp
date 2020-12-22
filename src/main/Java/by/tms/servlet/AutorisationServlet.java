package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/aut")
public class AutorisationServlet extends HttpServlet {
    private final InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = inMemoryStorage.getByLogin(login);
        if (byLogin != null) {
            if (password.equals(byLogin.getPassword())) {
                req.getSession().setAttribute("user", byLogin);
                resp.getWriter().println("Authorization complete");
            } else {
                resp.getWriter().println("Incorrect password");
            }
        } else {
            resp.getWriter().println("Incorrect login");
        }
    }

}

