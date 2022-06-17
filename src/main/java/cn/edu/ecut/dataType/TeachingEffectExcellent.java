package cn.edu.ecut.dataType;

public class TeachingEffectExcellent {
    private String TeacherID;
    private String TeacherName;

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    @Override
    public String toString() {
        return "TeachingEffectExcellent{" +
                "TeacherID='" + TeacherID + '\'' +
                ", TeacherName='" + TeacherName + '\'' +
                '}';
    }
}
