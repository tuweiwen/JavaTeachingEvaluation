package cn.edu.ecut.pojo;

public class Student {
    private String StudentID;
    private String StudentName;
    private String ClassNumber;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getClassNumber() {
        return ClassNumber;
    }

    public void setClassNumber(String classNumber) {
        ClassNumber = classNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", ClassNumber='" + ClassNumber + '\'' +
                '}';
    }
}
