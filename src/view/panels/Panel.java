package view.panels;

import javax.swing.*;
import java.awt.*;

public class Panel {
    static JPanel createPanel(String labelText) {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText);
        panel.add(label);
        return panel;
    }
}
