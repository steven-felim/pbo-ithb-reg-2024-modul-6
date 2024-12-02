package view.panels;

import javax.swing.*;

import static view.panels.Panel.createPanel;

public class InputPanel {
    public JPanel createInputTextPanel(JTextField text, String labelText) {
        JPanel panel = createPanel(labelText);
        panel.add(text);
        return panel;
    }
}
