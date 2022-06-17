package cn.edu.ecut.mapper;

import cn.edu.ecut.dataType.TeacherTeaching;

public interface TeacherMapper {
    TeacherTeaching CourseByTeacherName(String TeacherName);
}
