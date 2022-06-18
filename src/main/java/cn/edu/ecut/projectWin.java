package cn.edu.ecut;

import cn.edu.ecut.dataType.TeacherTeaching;
import cn.edu.ecut.dataType.TeacherTeachingTM;
import cn.edu.ecut.mapper.TeacherMapper;
import cn.edu.ecut.util.Session;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class projectWin{
    JFrame frame = new JFrame("评教系统(Beta)");
    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
    public void init(SqlSession session) {
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        List<TeacherTeaching> tempList = Collections.singletonList(teacherMapper.CourseByTeacherName("江霞"));
        System.out.println(tempList);

        JTable table = new JTable(new TeacherTeachingTM(tempList));

        tabbedPane.addTab("教师课程查询", new JScrollPane(table));
        tabbedPane.addTab("Tab2", new JList<>(new String[]{"tab2_item1", "tab2_item2", "tab2_item3"}));
        tabbedPane.addTab("Tab3", new JList<>(new String[]{"tab3_item1", "tab3_item2", "tab3_item3"}));
        tabbedPane.setSelectedIndex(0);

        frame.add(tabbedPane);
        frame.setBounds(400, 400, 400, 400);
        // frame.setResizable(false);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        SqlSession session = Session.getSession();

        new projectWin().init(session);
    }
}
