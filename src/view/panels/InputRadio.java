package view.panels;

import model.enums.GolonganDarah;
import model.enums.JenisKelamin;

import javax.swing.*;

import static view.panels.Panel.createPanel;

public class InputRadio {
    private ButtonGroup bGender, bGolDarah, bKewarganegaraan;
    private JTextField fWNA;

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

    public JenisKelamin getSelectedGender() {
        String selected = bGender.getSelection().getActionCommand();

        if (selected.equals(String.valueOf(JenisKelamin.PRIA))) {
            return JenisKelamin.PRIA;
        } else if (selected.equals(String.valueOf(JenisKelamin.WANITA))) {
            return JenisKelamin.WANITA;
        }
        return null;
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

    public GolonganDarah getSelectedGolonganDarah() {
        String selected = bGolDarah.getSelection().getActionCommand();

        if (selected.equals(String.valueOf(GolonganDarah.A))) {
            return GolonganDarah.A;
        } else if (selected.equals(String.valueOf(GolonganDarah.B))) {
            return GolonganDarah.B;
        } else if (selected.equals(String.valueOf(GolonganDarah.O))) {
            return GolonganDarah.O;
        } else if (selected.equals(String.valueOf(GolonganDarah.AB))) {
            return GolonganDarah.AB;
        }
        return null;
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

    public String getSelectedKewarganegaraan() {
        String selected = bKewarganegaraan.getSelection().getActionCommand();

        if (selected.equals("WNI")) {
            return "WNI";
        } else if (selected.equals("WNA")) {
            if (!fWNA.getText().isEmpty()) {
                return "WNA " + fWNA.getText();
            }
        }
        return null;
    }
}