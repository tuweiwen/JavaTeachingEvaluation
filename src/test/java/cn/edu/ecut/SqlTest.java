package cn.edu.ecut;

import cn.edu.ecut.dataType.TeacherTeaching;
import cn.edu.ecut.dataType.TeachingEffectExcellent;
import cn.edu.ecut.mapper.StudentMapper;
import cn.edu.ecut.mapper.TeacherMapper;
import cn.edu.ecut.mapper.TeachingMapper;
import cn.edu.ecut.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
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

    @Test
    public void testProcedure() throws IOException {
        String mybatisConfig = "mybatis-config.xml";
        InputStream iStream = Resources.getResourceAsStream(mybatisConfig);
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(iStream);

        SqlSession session  = fac.openSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        List<TeacherTeaching> tt = Collections.singletonList(teacherMapper.CourseByTeacherName("江霞"));

        System.out.println(tt);
        session.close();
    }

    @Test
    public void testView() throws IOException {
        String mybatisConfig = "mybatis-config.xml";
        InputStream iStream = Resources.getResourceAsStream(mybatisConfig);
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(iStream);

        SqlSession session  = fac.openSession();
        TeachingMapper teachingMapper = session.getMapper(TeachingMapper.class);
        List<TeachingEffectExcellent> te = Collections.singletonList(teachingMapper.SelectExcellentTC());

        System.out.println(te);
        session.close();
    }
}
