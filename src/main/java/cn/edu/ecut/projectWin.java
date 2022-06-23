package cn.edu.ecut;

import cn.edu.ecut.dataPrototype.*;
import cn.edu.ecut.tableModel.*;
import cn.edu.ecut.mapper.*;
import cn.edu.ecut.util.Session;
import cn.edu.ecut.viewUtil.SingleInputSearchTableView;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import java.util.List;

public class projectWin{
    JFrame frame = new JFrame("评教系统(Beta)");
    JMenuBar menuBar = new JMenuBar();
    JMenu window = new JMenu("窗口");
    JMenu help = new JMenu("帮助");
    JMenuItem closeWindow = new JMenuItem("关闭");
    JMenuItem about = new JMenuItem("关于");
    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

    // TableModel&Data
    String courseByTeacherNameKey = "江霞";
    TeachingEffectExcellentTM teachingEffectExcellentTM = new TeachingEffectExcellentTM();
    TeacherTeachingTM teacherTeachingTM = new TeacherTeachingTM();
    StudentEvaluationTM studentEvaluationTM = new StudentEvaluationTM();
    StudentPointAvgTM studentPointAvgTM = new StudentPointAvgTM();

    public void init(SqlSession session) {
        // menuItem 监听
        closeWindow.addActionListener(e -> frame.dispose());
        about.addActionListener(e -> JOptionPane.showMessageDialog(frame, "软件作者：涂为文\n班级：2021820\n" +
                "学号：2020216001", "关于软件", JOptionPane.INFORMATION_MESSAGE));

        window.add(closeWindow);
        help.add(about);
        menuBar.add(window);
        menuBar.add(help);
        frame.setJMenuBar(menuBar);

        // get mapper(for using sql function)
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        TeachingMapper teachingMapper = session.getMapper(TeachingMapper.class);
        StudentEvaluationMapper studentEvaluationMapper = session.getMapper(StudentEvaluationMapper.class);

        // init displayed data
        List<TeacherTeaching> teacherTeachingList = teacherMapper.CourseByTeacherName(courseByTeacherNameKey);
        List<TeachingEffectExcellent> teachingEffectExcellentList = teachingMapper.SelectExcellentTC();
        List<StudentEvaluation> studentEvaluationList = studentEvaluationMapper.SelectAll();
        List<StudentPointAvg> studentPointAvgList = studentEvaluationMapper.selectStudentPointAvg("2019213490");

        // init Table Model
        teachingEffectExcellentTM = new TeachingEffectExcellentTM(teachingEffectExcellentList);
        teacherTeachingTM = new TeacherTeachingTM(teacherTeachingList);
        studentEvaluationTM = new StudentEvaluationTM(studentEvaluationList);
        studentPointAvgTM = new StudentPointAvgTM(studentPointAvgList);

        // create table
        JTable teachingEffectExcellentTable = new JTable(teachingEffectExcellentTM);
        JTable teacherTeachingTable = new JTable(teacherTeachingTM);
        JTable studentEvaluationTable = new JTable(studentEvaluationTM);
        JTable studentPointAvgTable = new JTable(studentPointAvgTM);

        // TAB1 Panel
        JPanel teacherTeachingPanel = new JPanel(new BorderLayout());
        Box teacherTeachingPanelNorth = Box.createHorizontalBox();
        JLabel teacherNameInputHintLabel = new JLabel("教师名称：");
        JTextField teacherNameInput = new JTextField();
        JButton teacherTeachingSB = new JButton("搜索");
        teacherTeachingSB.addActionListener(
                e -> {
                    teacherTeachingTM = new TeacherTeachingTM(teacherMapper.CourseByTeacherName(
                            teacherNameInput.getText()));
                    teacherTeachingTable.setModel(teacherTeachingTM);
                }
        );
        SingleInputSearchTableView.initLayout(teacherTeachingPanel, teacherTeachingPanelNorth, teacherTeachingTable,
                teacherNameInputHintLabel, teacherNameInput, teacherTeachingSB);


        // Tab2 Panel
        JPanel studentEvaluationPanel = new JPanel(new BorderLayout());
        JPanel studentEvaluationNorth = new JPanel(new GridLayout(1, 3));
        JButton studentEvaluationInsert = new JButton("添加");
        studentEvaluationInsert.addActionListener(e -> JOptionPane.showMessageDialog(frame, "抱歉，该功能尚处于开发状态", "提示",
                JOptionPane.INFORMATION_MESSAGE));
        JButton studentEvaluationUpdate = new JButton("修改");
        studentEvaluationUpdate.addActionListener(e -> {
            // 获取行数
            int rowIndex = studentEvaluationTable.getSelectedRow();
            if (rowIndex == -1) {
                // System.out.println("请选择数据");
                return;
            }

            StudentEvaluation selectItem = studentEvaluationTM.getListItem(rowIndex);

            JFrame updateDataFrame = new JFrame("修改数据");
            GridLayout borderPanelGL = new GridLayout(5, 1);
            borderPanelGL.setVgap(10);
            JPanel borderPanel = new JPanel(borderPanelGL);
            borderPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

            Box studentIdValue = Box.createHorizontalBox();
            JTextField studentIdTF = new JTextField();
            studentIdTF.setText(selectItem.getStudentID());
            studentIdTF.setEditable(false);
            studentIdValue.add(new JLabel("学生ID :"));
            studentIdValue.add(Box.createHorizontalStrut(10));
            studentIdValue.add(studentIdTF);

            Box teacherIdValue = Box.createHorizontalBox();
            JTextField teacherIdTF = new JTextField();
            teacherIdTF.setText(selectItem.getTeacherID());
            teacherIdTF.setEditable(false);
            teacherIdValue.add(new JLabel("教师ID :"));
            teacherIdValue.add(Box.createHorizontalStrut(10));
            teacherIdValue.add(teacherIdTF);

            Box courseIdValue = Box.createHorizontalBox();
            JTextField courseIdTF = new JTextField();
            courseIdTF.setText(selectItem.getCourseID());
            courseIdTF.setEditable(false);
            courseIdValue.add(new JLabel("课程ID :"));
            courseIdValue.add(Box.createHorizontalStrut(10));
            courseIdValue.add(courseIdTF);

            Box pointValue = Box.createHorizontalBox();
            JTextField pointTF = new JTextField();
            pointTF.setText(selectItem.getPoint().toString());
            pointValue.add(new JLabel("评    分:"));
            pointValue.add(Box.createHorizontalStrut(10));
            pointValue.add(pointTF);

            Box buttonPanel = Box.createHorizontalBox();
            JButton updateButton = new JButton("确认");
            updateButton.addActionListener(e12 -> {
                double newPointValue;
                try {
                    newPointValue = Double.parseDouble(pointTF.getText());
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(updateDataFrame, "请不要在评分框内输入非法数值！\n" +
                            "(例如 : 非数字字符，空值等)", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (newPointValue > 100D || newPointValue < 0D) {
                    JOptionPane.showMessageDialog(updateDataFrame, "评分数值不合法！\n" +
                            "(合法值 : 0.00 - 100.00)", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // update data in db
                studentEvaluationMapper.updateValue(studentIdTF.getText(), courseIdTF.getText(),
                        teacherIdTF.getText(), newPointValue);
                // update TableModel data source(update view)
                studentEvaluationTM = new StudentEvaluationTM(studentEvaluationMapper.SelectAll());
                studentEvaluationTable.setModel(studentEvaluationTM);
                teachingEffectExcellentTM = new TeachingEffectExcellentTM(teachingMapper.SelectExcellentTC());
                teachingEffectExcellentTable.setModel(teachingEffectExcellentTM);

                updateDataFrame.dispose();
            });
            JButton cancelButton = new JButton("取消");
            cancelButton.addActionListener(e1 -> updateDataFrame.dispose());

            buttonPanel.add(Box.createHorizontalStrut(50));
            buttonPanel.add(updateButton);
            buttonPanel.add(Box.createHorizontalStrut(50));
            buttonPanel.add(cancelButton);
            buttonPanel.add(Box.createHorizontalStrut(50));

            borderPanel.add(studentIdValue);
            borderPanel.add(teacherIdValue);
            borderPanel.add(courseIdValue);
            borderPanel.add(pointValue);
            borderPanel.add(buttonPanel);
            updateDataFrame.add(borderPanel);

            updateDataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateDataFrame.setSize(300, 300);
            updateDataFrame.setLocationRelativeTo(frame);
            updateDataFrame.setResizable(false);
            updateDataFrame.setVisible(true);
        });
        JButton studentEvaluationDelete = new JButton("删除");
        studentEvaluationDelete.addActionListener(e -> {
                    int rowIndex = studentEvaluationTable.getSelectedRow();
                    if (rowIndex == -1) {
                        return;
                    }

                    StudentEvaluation selectItem = studentEvaluationTM.getListItem(rowIndex);

                    int confirmDelete = JOptionPane.showConfirmDialog(frame, "确认删除该条记录吗？", "警告",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmDelete == JOptionPane.YES_OPTION) {
                        studentEvaluationMapper.deleteItem(selectItem.getStudentID(), selectItem.getCourseID(),
                                selectItem.getTeacherID());
                        studentEvaluationTM = new StudentEvaluationTM(studentEvaluationMapper.SelectAll());
                        studentEvaluationTable.setModel(studentEvaluationTM);
                    }
                });
        studentEvaluationNorth.add(studentEvaluationInsert);
        studentEvaluationNorth.add(studentEvaluationUpdate);
        studentEvaluationNorth.add(studentEvaluationDelete);
        studentEvaluationPanel.add(studentEvaluationNorth, BorderLayout.NORTH);
        studentEvaluationPanel.add(new JScrollPane(studentEvaluationTable));

        // Tab3 Panel
        JPanel studentPointAvgPanel = new JPanel(new BorderLayout());
        Box studentPointAvgPanelNorth = Box.createHorizontalBox();
        JLabel studentIdInputHintLabel = new JLabel("学生ID：");
        JTextField studentIdInput = new JTextField();
        JButton studentIdSB = new JButton("搜索");
        studentIdSB.addActionListener(e -> {
                studentPointAvgTM = new StudentPointAvgTM(studentEvaluationMapper.
                        selectStudentPointAvg(studentIdInput.getText()));
                studentPointAvgTable.setModel(studentPointAvgTM);
            });
        SingleInputSearchTableView.initLayout(studentPointAvgPanel, studentPointAvgPanelNorth, studentPointAvgTable,
                studentIdInputHintLabel, studentIdInput, studentIdSB);

        // add Tab0
        tabbedPane.addTab("授课效果优秀的教师(视图)", new JScrollPane(teachingEffectExcellentTable));
        // add Tab1
        tabbedPane.addTab("教师课程查询(存储过程)", teacherTeachingPanel);
        // add Tab2
        tabbedPane.addTab("学生评教信息(触发器)", studentEvaluationPanel);
        // add Tab3
        tabbedPane.addTab("查询学生平均评分(函数)", studentPointAvgPanel);
        tabbedPane.setSelectedIndex(0);

        frame.add(tabbedPane);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        // Connect to database, using util.Session
        SqlSession session = Session.getSession();

        new projectWin().init(session);
    }
}
