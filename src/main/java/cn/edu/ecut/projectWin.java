package cn.edu.ecut;

import cn.edu.ecut.dataType.*;
import cn.edu.ecut.mapper.StudentEvaluationMapper;
import cn.edu.ecut.mapper.TeacherMapper;
import cn.edu.ecut.mapper.TeachingMapper;
import cn.edu.ecut.util.Session;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
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

    // 数据
    String courseByTeacherNameKey = "江霞";
    TeacherTeachingTM teacherTeachingTM = new TeacherTeachingTM();

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

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        TeachingMapper teachingMapper = session.getMapper(TeachingMapper.class);
        StudentEvaluationMapper studentEvaluationMapper = session.getMapper(StudentEvaluationMapper.class);
        List<TeacherTeaching> teacherTeachingList = teacherMapper.CourseByTeacherName(courseByTeacherNameKey);
        List<TeachingEffectExcellent> teachingEffectExcellentList = teachingMapper.SelectExcellentTC();
        List<StudentEvaluation> studentEvaluationList = studentEvaluationMapper.SelectAll();

        teacherTeachingTM = new TeacherTeachingTM(teacherTeachingList);

        JTable teacherTeachingTable = new JTable(teacherTeachingTM);
        JTable teachingEffectExcellentTable = new JTable(new TeachingEffectExcellentTM(teachingEffectExcellentList));
        JTable studentEvaluationTable = new JTable(new StudentEvaluationTM(studentEvaluationList));

        // TAB1 Panel
        JPanel teacherTeachingPanel = new JPanel(new BorderLayout());
        Box teacherTeachingPanelNorth = Box.createHorizontalBox();
        JLabel teacherNameInputHintLabel = new JLabel("教师名称：");
        JTextField teacherNameInput = new JTextField();
        JButton searchButton = new JButton("搜索");
        searchButton.addActionListener(
                e -> {
                    teacherTeachingTM = new TeacherTeachingTM(teacherMapper.CourseByTeacherName(
                            teacherNameInput.getText()));
                    teacherTeachingTable.setModel(teacherTeachingTM);
                }
        );

        teacherTeachingPanelNorth.add(teacherNameInputHintLabel);
        teacherTeachingPanelNorth.add(Box.createHorizontalStrut(10));
        teacherTeachingPanelNorth.add(teacherNameInput);
        teacherTeachingPanelNorth.add(Box.createHorizontalStrut(10));
        teacherTeachingPanelNorth.add(searchButton);
        teacherTeachingPanel.add(teacherTeachingPanelNorth, BorderLayout.NORTH);
        teacherTeachingPanel.add(new JScrollPane(teacherTeachingTable), BorderLayout.CENTER);
        // 结束

        // Tab2 Panel
        JPanel studentEvaluationPanel = new JPanel(new BorderLayout());
        JPanel studentEvaluationNorth = new JPanel(new GridLayout(1, 3));
        JButton studentEvaluationInsert = new JButton("添加");
        JButton studentEvaluationUpdate = new JButton("修改");
        JButton studentEvaluationDelete = new JButton("删除");
        studentEvaluationNorth.add(studentEvaluationInsert);
        studentEvaluationNorth.add(studentEvaluationUpdate);
        studentEvaluationNorth.add(studentEvaluationDelete);
        studentEvaluationPanel.add(studentEvaluationNorth, BorderLayout.NORTH);
        studentEvaluationPanel.add(new JScrollPane(studentEvaluationTable));
        // 结束

        // Tab0
        tabbedPane.addTab("授课效果优秀的教师", new JScrollPane(teachingEffectExcellentTable));
        // Tab1
        tabbedPane.addTab("教师课程查询", teacherTeachingPanel);
        // Tab2
        tabbedPane.addTab("学生评教信息", studentEvaluationPanel);
        tabbedPane.setSelectedIndex(0);

        frame.add(tabbedPane);
        frame.setBounds(400, 400, 600, 500);
        frame.setResizable(true);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        SqlSession session = Session.getSession();

        new projectWin().init(session);
    }
}
