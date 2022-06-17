package cn.edu.ecut.pojo;

public class StudentEvaluation {
    private String StudentID;
    private String TeacherID;
    private String CourseID;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

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

    public Double getPoint() {
        return Point;
    }

    public void setPoint(Double point) {
        Point = point;
    }

    private Double Point;

    @Override
    public String toString() {
        return "StudentEvaluation{" +
                "StudentID='" + StudentID + '\'' +
                ", TeacherID='" + TeacherID + '\'' +
                ", CourseID='" + CourseID + '\'' +
                ", Point=" + Point +
                '}';
    }
}
