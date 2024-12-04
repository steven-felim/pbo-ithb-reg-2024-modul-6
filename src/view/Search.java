package view;

import controller.DeleteData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search extends JFrame implements ActionListener {
    JButton button, button1, button2;
    JTextField nikField;

    public Search() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Search Page");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel formContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formContainer.add(createInputTextPanel("NIK : "), gbc);

        button = new JButton("Delete");
        button1 = new JButton("Update");
        button2 = new JButton("Show");

        button.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);

        button.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);

        gbc.gridy++;
        gbc.gridwidth = 1;
        formContainer.add(button, gbc);

        gbc.gridx++;
        formContainer.add(button1, gbc);

        gbc.gridx++;
        formContainer.add(button2, gbc);

        this.add(formContainer);
        this.setVisible(true);
    }

    private JPanel createInputTextPanel(String labelText) {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText);
        nikField = new JTextField(20);

        panel.add(label);
        panel.add(nikField);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Delete":
                DeleteData delete = new DeleteData();
                boolean valid = delete.DeleteFromDatabase(nikField.getText());
                if (valid) {
                    JOptionPane.showMessageDialog(null, "Data has been deleted");
                } else {
                    JOptionPane.showMessageDialog(null, "Task Failed !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                new Menu();
                this.dispose();
                break;
            case "Update":
                new UpdateForm(nikField.getText());
                this.dispose();
                break;
            case "Show":
                new Hasil(true, nikField.getText());
                this.dispose();
                break;
        }
    }
}
