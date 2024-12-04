package view.panels;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static view.panels.Panel.createPanel;

public class InputCheckBox {
    public List<JCheckBox> pekerjaan;

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

    public JPanel createCheckBoxPekerjaan(String labelText, String selected) {
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

        if (selected.equals("Pengangguran ")) {
            pengangguran.setSelected(true);
        } else {
            String[] pekerjaan = selected.split(" ");
            for (String kerja : pekerjaan) {
                switch (kerja) {
                    case "KaryawanSwasta":
                        karyawan.setSelected(true);
                        break;
                    case "PNS":
                        pns.setSelected(true);
                        break;
                    case "Wiraswasta":
                        wiraswasta.setSelected(true);
                        break;
                    case "Akademisi":
                        akademisi.setSelected(true);
                        break;
                }
            }
        }

        return panel;
    }
}