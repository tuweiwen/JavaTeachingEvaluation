package cn.edu.ecut.pojo;

public class Teaching {
    private String TeacherID;
    private String CourseID;
    private String Effect;

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getEffect() {
        return Effect;
    }

    public void setEffect(String effect) {
        Effect = effect;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "TeacherID='" + TeacherID + '\'' +
                ", CourseID='" + CourseID + '\'' +
                ", Effect='" + Effect + '\'' +
                '}';
    }
}
