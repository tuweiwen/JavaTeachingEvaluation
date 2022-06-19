package cn.edu.ecut.dataType;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentEvaluationTM extends AbstractTableModel {
    List<StudentEvaluation> valueList;

    public StudentEvaluationTM() {
        valueList = new ArrayList<>();
    }

    public StudentEvaluationTM(List<StudentEvaluation> list){
        valueList = list;
    }

    public StudentEvaluation getListItem(int itemIndex){
        return valueList.get(itemIndex);
    }

    @Override
    public int getRowCount() {
        return valueList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= getRowCount() || rowIndex < 0)
            return null;
        StudentEvaluation tempObj = valueList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tempObj.getStudentID();
            case 1:
                return tempObj.getTeacherID();
            case 2:
                return tempObj.getCourseID();
            case 3:
                return tempObj.getPoint();
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
                return "学生ID";
            case 1:
                return "教师ID";
            case 2:
                return "课程号";
            case 3:
                return "学生评分";
        }
        return null;
    }


}
