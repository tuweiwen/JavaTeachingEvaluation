package cn.edu.ecut.tableModel;

import cn.edu.ecut.dataPrototype.TeacherTeaching;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TeacherTeachingTM extends AbstractTableModel {

    List<TeacherTeaching> valueList;

    public TeacherTeachingTM() {
        valueList = new ArrayList<>();
    }
    public TeacherTeachingTM(List<TeacherTeaching> list) {
        valueList = list;
    }

    @Override
    public int getRowCount() {
        return valueList.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= getRowCount() || rowIndex < 0)
            return null;
        TeacherTeaching tempObj = valueList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tempObj.getCourseID();
            case 1:
                return tempObj.getCourseName();
            case 2:
                return tempObj.getCredit();
            case 3:
                return tempObj.getAttribute();
            case 4:
                return tempObj.getTeacherName();
            case 5:
                return tempObj.getTeacherID();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "课程ID";
            case 1:
                return "课程名称";
            case 2:
                return "学分";
            case 3:
                return "课程属性";
            case 4:
                return "教师名称";
            case 5:
                return "教师ID";
        }
        return null;
    }
}