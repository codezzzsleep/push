package icu.zzzsleep;

import icu.zzzsleep.mapper.UserMapper;
import icu.zzzsleep.project.Todo;
import icu.zzzsleep.service.TodoService;
import icu.zzzsleep.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

import icu.zzzsleep.project.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class test {
    public static void main(String[] args) throws IOException {
//        String username = "aaa";
//        String password = "aaa";
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.select(username, password);
//        System.out.println(user);
        TodoService service = new TodoService();
        List<Todo> todos = service.selectAll(1);
        System.out.println(todos);
        for (int i = todos.size()-1; i >= 0; i--) {
            Todo todo = todos.get(i);
            if (todo.getIsDelete() == 1) {
                todos.remove(todo);
            }
        }
        System.out.println(todos);
    }
}
