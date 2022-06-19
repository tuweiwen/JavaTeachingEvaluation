package cn.edu.ecut.dataType;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentPointAvgTM extends AbstractTableModel {
    List<StudentPointAvg> valueList;

    public StudentPointAvgTM() {
        valueList = new ArrayList<>();
    }

    public StudentPointAvgTM(List<StudentPointAvg> list) {
        valueList = list;
    }

    @Override
    public int getRowCount() {
        return valueList.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= getRowCount() || rowIndex < 0)
            return null;
        StudentPointAvg tempObj = valueList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tempObj.getStudentID();
            case 1:
                return tempObj.getPointAvg();
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
                return "评分平均值";
        }
        return null;
    }
}
