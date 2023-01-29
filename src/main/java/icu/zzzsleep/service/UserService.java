package icu.zzzsleep.service;

import icu.zzzsleep.mapper.UserMapper;
import icu.zzzsleep.project.User;
import icu.zzzsleep.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username,password);
        sqlSession.close();
        return user;
    }
}
