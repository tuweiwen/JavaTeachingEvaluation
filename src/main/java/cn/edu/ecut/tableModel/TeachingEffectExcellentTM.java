package cn.edu.ecut.tableModel;

import cn.edu.ecut.dataPrototype.TeachingEffectExcellent;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TeachingEffectExcellentTM extends AbstractTableModel {
    List<TeachingEffectExcellent> valueList;

    public TeachingEffectExcellentTM() {
        valueList = new ArrayList<>();
    }

    public TeachingEffectExcellentTM(List<TeachingEffectExcellent>list) {
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
        if (rowIndex >= getColumnCount() || rowIndex < 0)
            return null;
        TeachingEffectExcellent tempObj = valueList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tempObj.getTeacherID();
            case 1:
                return tempObj.getTeacherName();
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
                return "教师名称";
            case 1:
                return "教师ID";
        }
        return null;
    }
}
