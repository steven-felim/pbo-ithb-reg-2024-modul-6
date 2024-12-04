package view.panels;

import model.enums.GolonganDarah;
import model.enums.JenisKelamin;

import javax.swing.*;

import static view.panels.Panel.createPanel;

public class InputRadio {
    public ButtonGroup bGender, bGolDarah, bKewarganegaraan;
    public JTextField fWNA;

    public JPanel createRadGender(String labelText) {
        JPanel panel = createPanel(labelText);
        JRadioButton pria = new JRadioButton(String.valueOf(JenisKelamin.PRIA));
        JRadioButton wanita = new JRadioButton(String.valueOf(JenisKelamin.WANITA));

        pria.setActionCommand(pria.getText());
        wanita.setActionCommand(wanita.getText());

        bGender = new ButtonGroup();
        bGender.add(pria);
        bGender.add(wanita);

        panel.add(pria);
        panel.add(wanita);
        return panel;
    }

    public JPanel createRadGender(String labelText, String selected) {
        JPanel panel = createPanel(labelText);

        JRadioButton radioButtonM = new JRadioButton(String.valueOf(JenisKelamin.PRIA));
        JRadioButton radioButtonF = new JRadioButton(String.valueOf(JenisKelamin.WANITA));

        radioButtonM.setActionCommand(radioButtonM.getText());
        radioButtonF.setActionCommand(radioButtonF.getText());

        bGender = new ButtonGroup();
        bGender.add(radioButtonM);
        bGender.add(radioButtonF);

        panel.add(radioButtonM);
        panel.add(radioButtonF);

        if (selected.equals("PRIA")) {
            radioButtonM.setSelected(true);
        } else {
            radioButtonF.setSelected(true);
        }

        return panel;
    }

    public JPanel createRadGolDarah(String labelText) {
        JPanel panel = createPanel(labelText);
        JRadioButton a = new JRadioButton(String.valueOf(GolonganDarah.A));
        JRadioButton b = new JRadioButton(String.valueOf(GolonganDarah.B));
        JRadioButton o = new JRadioButton(String.valueOf(GolonganDarah.O));
        JRadioButton ab = new JRadioButton(String.valueOf(GolonganDarah.AB));

        a.setActionCommand(a.getText());
        b.setActionCommand(b.getText());
        o.setActionCommand(o.getText());
        ab.setActionCommand(ab.getText());

        bGolDarah = new ButtonGroup();
        bGolDarah.add(a);
        bGolDarah.add(b);
        bGolDarah.add(o);
        bGolDarah.add(ab);

        panel.add(a);
        panel.add(b);
        panel.add(o);
        panel.add(ab);
        return panel;
    }

    public JPanel createRadGolDarah(String labelText, String selected) {
        JPanel panel = createPanel(labelText);

        JRadioButton a = new JRadioButton(String.valueOf(GolonganDarah.A));
        JRadioButton b = new JRadioButton(String.valueOf(GolonganDarah.B));
        JRadioButton o = new JRadioButton(String.valueOf(GolonganDarah.O));
        JRadioButton ab = new JRadioButton(String.valueOf(GolonganDarah.AB));

        a.setActionCommand(a.getText());
        b.setActionCommand(b.getText());
        o.setActionCommand(o.getText());
        ab.setActionCommand(ab.getText());

        bGolDarah = new ButtonGroup();
        bGolDarah.add(a);
        bGolDarah.add(b);
        bGolDarah.add(o);
        bGolDarah.add(ab);

        panel.add(a);
        panel.add(b);
        panel.add(o);
        panel.add(ab);

        switch (selected) {
            case "A":
                a.setSelected(true);
                break;
            case "B":
                b.setSelected(true);
                break;
            case "AB":
                ab.setSelected(true);
                break;
            default:
                o.setSelected(true);
                break;
        }

        return panel;
    }

    public JPanel createRadWN(String labelText) {
        JPanel panel = createPanel(labelText);
        JRadioButton wni = new JRadioButton("WNI");
        JRadioButton wna = new JRadioButton("WNA");

        bKewarganegaraan  = new ButtonGroup();
        bKewarganegaraan.add(wni);
        bKewarganegaraan.add(wna);
        
        fWNA = new JTextField(20);
        fWNA.setVisible(false);

        panel.add(wni);
        panel.add(wna);
        panel.add(fWNA);

        wna.addActionListener(e -> {
            if (wna.isSelected()) {
                fWNA.setVisible(true);
                panel.revalidate();;
                panel.repaint();
            }
        });

        wni.addActionListener(e -> {
            if (wni.isSelected()) {
                fWNA.setVisible(false);
                panel.revalidate();
                panel.repaint();
            }
        });

        wni.setActionCommand(wni.getText());
        wna.setActionCommand(wna.getText());

        return panel;
    }

    public JPanel createRadWN(String labelText, String selected) {
        JPanel panel = createPanel(labelText);

        JRadioButton wni = new JRadioButton("WNI");
        JRadioButton wna = new JRadioButton("WNA");

        wni.setActionCommand("WNI");
        wna.setActionCommand("WNA");

        bKewarganegaraan = new ButtonGroup();
        bKewarganegaraan.add(wni);
        bKewarganegaraan.add(wna);

        fWNA = new JTextField(20);
        fWNA.setVisible(false);

        if(selected.equalsIgnoreCase("WNI ")){
            wni.setSelected(true);
        }else{
            String[] split = selected.split(" ");
            wna.setSelected(true);
            fWNA = new JTextField(split[1],20);
        }

        panel.add(wni);
        panel.add(wna);
        panel.add(fWNA);

        wna.addActionListener(e -> {
            if (wna.isSelected()) {
                fWNA.setVisible(true);
                panel.revalidate();
                panel.repaint();
            }
        });

        wni.addActionListener(e -> {
            if (wni.isSelected()) {
                fWNA.setVisible(false);
                panel.revalidate();
                panel.repaint();
            }
        });

        return panel;
    }
}