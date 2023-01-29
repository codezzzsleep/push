package icu.zzzsleep.service;

import icu.zzzsleep.mapper.TodoMapper;
import icu.zzzsleep.project.Todo;
import icu.zzzsleep.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TodoService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Todo> selectAll(int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TodoMapper mapper = sqlSession.getMapper(TodoMapper.class);
        List<Todo> todos = mapper.selectAll(userid);
        sqlSession.close();
        return todos;
    }
}
