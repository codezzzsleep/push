package icu.zzzsleep.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String[] urls = {"/login.html","/img/","/css/","/login","/js/","/element-ui/"};
        String url = req.getRequestURL().toString();
        for (String u : urls) {
            if(url.contains(u)){
                chain.doFilter(request, response);
                return;
            }
        }


        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if(user != null){
            chain.doFilter(request, response);
        }else {
//            resp.setStatus(202);
            resp.sendRedirect("login.html");

        }


    }


    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }


}
