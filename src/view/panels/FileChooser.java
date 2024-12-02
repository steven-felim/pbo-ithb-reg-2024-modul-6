package view.panels;

import model.classes.DataKTP;

import javax.swing.*;

import static view.panels.Panel.createPanel;

public class FileChooser {
    public JPanel createFileChooserFoto(JFileChooser fileChooser, String labelText, DataKTP data) {
        JPanel panel = createPanel(labelText);
        JButton browseButton = new JButton("Browse...");
        browseButton.addActionListener(e -> {
            int returnValue = fileChooser.showOpenDialog(panel);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                data.setFoto(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        panel.add(browseButton);
        return panel;
    }

    public JPanel createFileChooserTtd(JFileChooser fileChooser, String labelText, DataKTP data) {
        JPanel panel = createPanel(labelText);
        JButton browseButton = new JButton("Browse...");
        browseButton.addActionListener(e -> {
            int returnValue = fileChooser.showOpenDialog(panel);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                data.setTandaTangan(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        panel.add(browseButton);
        return panel;
    }
}
