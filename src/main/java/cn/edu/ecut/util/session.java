package cn.edu.ecut.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class session {
    public static SqlSession getSession() throws IOException {
        String mybatisConfig = "mybatis-config.xml";
        InputStream iStream = Resources.getResourceAsStream(mybatisConfig);
        return new SqlSessionFactoryBuilder().build(iStream).openSession();
    }
}
