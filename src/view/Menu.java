package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JButton input, search;
    public Menu() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Menu Page");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input = new JButton("Input");
        search = new JButton("Search");

        input.setEnabled(true);
        search.setEnabled(true);

        input.addActionListener(this);
        search.addActionListener(this);

        this.setLayout(new GridLayout(1, 2));
        this.add(input);
        this.add(search);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Input":
                new InputForm();
                this.dispose();
                break;
            case "Search":
                new Search();
                this.dispose();
                break;
        }
    }
}