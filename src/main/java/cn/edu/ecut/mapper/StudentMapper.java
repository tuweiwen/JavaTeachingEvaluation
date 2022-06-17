package cn.edu.ecut.mapper;

import cn.edu.ecut.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudentById(String ID);
}
