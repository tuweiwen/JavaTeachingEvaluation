package cn.edu.ecut;

import cn.edu.ecut.mapper.StudentMapper;
import cn.edu.ecut.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlTest {

    @Test
    public void testConnection() throws IOException{
        String mybatisConfig = "mybatis-config.xml";
        InputStream iStream = Resources.getResourceAsStream(mybatisConfig);
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(iStream);

        SqlSession session = fac.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> stu = studentMapper.getStudentById("2020216001");

        System.out.println(stu);
        session.close();
    }
}
