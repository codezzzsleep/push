package icu.zzzsleep.web;

import icu.zzzsleep.project.User;
import icu.zzzsleep.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);
        User user = service.login(username, password);
        System.out.println(user);
        String contextPath = request.getContextPath();
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect(contextPath);
            System.out.println("success");
        } else {
            response.setStatus(201);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
