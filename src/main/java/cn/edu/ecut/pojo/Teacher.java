package cn.edu.ecut.pojo;

import java.util.Date;

public class Teacher {
    private String TeacherID;
    private String TeacherName;
    private String Gender;
    private Date Birthday;
    private String Title;
    private Date ParticipateDate;
    private String Department;

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

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getParticipateDate() {
        return ParticipateDate;
    }

    public void setParticipateDate(Date participateDate) {
        ParticipateDate = participateDate;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
