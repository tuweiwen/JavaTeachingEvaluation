package cn.edu.ecut.dataType;

public class TeacherTeaching {
    private String CourseID;
    private String CourseName;
    private Double Credit;
    private String Attribute;
    private String TeacherName;
    private String TeacherID;

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public Double getCredit() {
        return Credit;
    }

    public void setCredit(Double credit) {
        Credit = credit;
    }

    public String getAttribute() {
        return Attribute;
    }

    public void setAttribute(String attribute) {
        Attribute = attribute;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    @Override
    public String toString() {
        return "TeacherTeaching{" +
                "CourseID='" + CourseID + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", Credit=" + Credit +
                ", Attribute='" + Attribute + '\'' +
                ", TeacherName='" + TeacherName + '\'' +
                ", TeacherID='" + TeacherID + '\'' +
                '}';
    }
}
