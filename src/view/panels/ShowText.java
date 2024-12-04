package view.panels;

import javax.swing.*;
import java.awt.*;

import static view.panels.Panel.createPanel;

public class ShowText {
    public JPanel createTextPanel(String input, String labelText) {
        JPanel panel;

        if (labelText.equals("")){
            panel = new JPanel();
        } else {
            panel = createPanel(labelText + " " + input);
            if(labelText.equalsIgnoreCase("NIK : ")){
                Font font = new Font("SansSerif", Font.BOLD, 20);
                panel.setFont(font);
            }
        }
        return panel;
    }
}