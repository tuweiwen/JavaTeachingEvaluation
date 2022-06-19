package cn.edu.ecut.dataType;

public class StudentPointAvg {
    private String StudentID;
    private Double PointAvg;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public Double getPointAvg() {
        return PointAvg;
    }

    public void setPointAvg(Double pointAvg) {
        PointAvg = pointAvg;
    }

    @Override
    public String toString() {
        return "StudentPointAvg{" +
                "StudentID='" + StudentID + '\'' +
                ", PointAvg=" + PointAvg +
                '}';
    }
}
