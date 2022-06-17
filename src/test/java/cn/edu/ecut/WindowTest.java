package cn.edu.ecut;

import org.junit.Test;

import javax.swing.*;

public class WindowTest {

    @Test
    public void testBasicWindow() {
        JFrame mainFrame = new JFrame();
        JPanel testPanel = new JPanel();
        JLabel testLabel = new JLabel("Hello World!");

        testPanel.add(testLabel);
        mainFrame.add(testPanel);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
