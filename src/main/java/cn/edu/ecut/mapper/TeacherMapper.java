package cn.edu.ecut.mapper;

import cn.edu.ecut.dataType.TeacherTeaching;

import java.util.List;

public interface TeacherMapper {
    List<TeacherTeaching> CourseByTeacherName(String TeacherName);
    List<TeacherTeaching> SelectAll();
}
