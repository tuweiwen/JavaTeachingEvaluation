package cn.edu.ecut.mapper;

import cn.edu.ecut.dataType.StudentEvaluation;
import cn.edu.ecut.dataType.StudentPointAvg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentEvaluationMapper {
    List<StudentEvaluation> SelectAll();
    void updateValue(@Param("StudentID") String StudentID, @Param("CourseID") String CourseID,
                     @Param("TeacherID") String TeacherID, @Param("Point") Double Point);

    void deleteItem(@Param("StudentID") String StudentID, @Param("CourseID") String CourseID,
                    @Param("TeacherID") String TeacherID);

    List<StudentPointAvg> selectStudentPointAvg(@Param("StudentID") String StudentID);
}
