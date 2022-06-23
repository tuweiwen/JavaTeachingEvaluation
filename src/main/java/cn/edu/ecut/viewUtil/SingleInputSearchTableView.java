package cn.edu.ecut.viewUtil;

import javax.swing.*;
import java.awt.*;

public class SingleInputSearchTableView {
    public static void initLayout(JPanel basePanel, Box panelNorth,
                              JTable displayTable, JLabel hintLabel, JTextField inputField, JButton searchBtn) {
        panelNorth.add(hintLabel);
        panelNorth.add(Box.createHorizontalStrut(10));
        panelNorth.add(inputField);
        panelNorth.add(Box.createHorizontalStrut(10));
        panelNorth.add(searchBtn);

        basePanel.add(panelNorth, BorderLayout.NORTH);
        basePanel.add(new JScrollPane(displayTable), BorderLayout.CENTER);
    }
}
