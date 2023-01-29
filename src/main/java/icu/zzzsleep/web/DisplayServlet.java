package icu.zzzsleep.web;

import com.alibaba.fastjson.JSON;
import icu.zzzsleep.project.Todo;
import icu.zzzsleep.project.User;
import icu.zzzsleep.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
    private TodoService service =new TodoService();;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object object = session.getAttribute("user");
        User user = (User)object;
        int userid = user.getId();
        List<Todo> todos = service.selectAll(userid);
        for (int i = todos.size()-1; i >= 0; i--) {
            Todo todo = todos.get(i);
            if (todo.getIsDelete() == 1) {
                todos.remove(todo);
            }
        }
        String jsonString = JSON.toJSONString(todos);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
