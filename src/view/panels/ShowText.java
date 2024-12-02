package view.panels;

import javax.swing.*;
import java.awt.*;

import static view.panels.Panel.createPanel;

public class ShowText {
    public JPanel createTextPanel(String input, String labelText) {
        JPanel panel;
        JTextArea textArea = new JTextArea(input);

        if (labelText.equals("")){
            panel = new JPanel();
        } else {
            panel = createPanel(labelText);

            if(labelText.equalsIgnoreCase("NIK : ")){
                Font font = new Font("SansSerif", Font.BOLD, 20);
                textArea.setFont(font);
            }
        }

        panel.add(textArea);
        return panel;
    }
}