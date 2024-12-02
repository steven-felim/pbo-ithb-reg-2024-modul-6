package view.panels;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static view.panels.Panel.createPanel;

public class InputCheckBox {
    private List<JCheckBox> pekerjaan;

    public JPanel createCheckBoxPekerjaan(String labelText) {
        JPanel panel = createPanel(labelText);

        JCheckBox karyawan = new JCheckBox("Karyawan Swasta");
        JCheckBox pns = new JCheckBox("Pegawai Negeri Sipil");
        JCheckBox wiraswasta = new JCheckBox("Wiraswasta");
        JCheckBox akademisi = new JCheckBox("Akademisi");
        JCheckBox pengangguran = new JCheckBox("Pengangguran");

        pekerjaan = new ArrayList<>();
        pekerjaan.add(karyawan);
        pekerjaan.add(pns);
        pekerjaan.add(wiraswasta);
        pekerjaan.add(akademisi);
        pekerjaan.add(pengangguran);

        for (JCheckBox checkBox : pekerjaan) {
            panel.add(checkBox);
        }

        pengangguran.addActionListener(e -> {
            if (pengangguran.isSelected()) {
                karyawan.setEnabled(false);
                pns.setEnabled(false);
                wiraswasta.setEnabled(false);
                akademisi.setEnabled(false);

                karyawan.setSelected(false);
                pns.setSelected(false);
                wiraswasta.setSelected(false);
                akademisi.setSelected(false);
            } else {
                karyawan.setEnabled(true);
                pns.setEnabled(true);
                wiraswasta.setEnabled(true);
                akademisi.setEnabled(true);
            }
        });

        return panel;
    }

    public String getSelectedPekerjaan() {
        List<String> selectedPekerjaan = new ArrayList<>();

        if (pekerjaan.get(0).isSelected()) {
            selectedPekerjaan.add("Karyawan Swasta");
        }
        if (pekerjaan.get(1).isSelected()) {
            selectedPekerjaan.add("Pegawai Negeri Sipil");
        }
        if (pekerjaan.get(2).isSelected()) {
            selectedPekerjaan.add("Wiraswasta");
        }
        if (pekerjaan.get(3).isSelected()) {
            selectedPekerjaan.add("Akademisi");
        }
        if (pekerjaan.get(4).isSelected()) {
            selectedPekerjaan.add("Pengangguran");
        }

        return String.join(", ", selectedPekerjaan);
    }

}
