package view.panels;

import model.enums.Agama;
import model.enums.StatusPerkawinan;

import javax.swing.*;

import static view.panels.Panel.createPanel;

public class InputComboBox {
    public JComboBox<String> cAgama, cStatusKawin;

    public JPanel createInputComboBoxAgama(String labelText) {
        JPanel panel = createPanel(labelText);
        Agama[] agama = Agama.values();
        Object[] arrAgama = new Object[agama.length + 1];
        arrAgama[0] = "";
        System.arraycopy(agama, 0, arrAgama, 1, agama.length);

        cAgama = new JComboBox(arrAgama);
        panel.add(cAgama);
        return panel;
    }

    public JPanel createInputComboBoxAgama(String labelText, Agama selected) {
        JPanel panel = createPanel(labelText);

        Object[] arrAgama = Agama.values();

        cAgama = new JComboBox(arrAgama);
        panel.add(cAgama);

        cAgama.setSelectedItem(selected);
        return panel;
    }

    public JPanel createInputComboBoxStatusKawin(String labelText) {
        JPanel panel = createPanel(labelText);
        StatusPerkawinan[] status = StatusPerkawinan.values();
        Object[] arrStatusPerkawinan = new Object[status.length + 1];
        arrStatusPerkawinan[0] = "";
        System.arraycopy(status, 0, arrStatusPerkawinan, 1, status.length);

        cStatusKawin = new JComboBox(arrStatusPerkawinan);
        panel.add(cStatusKawin);
        return panel;
    }

    public JPanel createInputComboBoxStatusKawin(String labelText, StatusPerkawinan selected) {
        JPanel panel = createPanel(labelText);

        Object[] arrStatusPerkawinan = StatusPerkawinan.values();

        cStatusKawin = new JComboBox(arrStatusPerkawinan);
        panel.add(cStatusKawin);

        cStatusKawin.setSelectedItem(selected);
        return panel;
    }
}
