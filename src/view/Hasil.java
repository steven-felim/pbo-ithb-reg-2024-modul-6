package view;

import model.classes.DataKTP;
import view.panels.ShowImage;
import view.panels.ShowText;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import java.awt.*;

public class Hasil extends JFrame {
    private ShowText show = new ShowText();
    private ShowImage img = new ShowImage();

    public void HasilKTP(DataKTP data) {
        initComponents(data);
    }

    private void initComponents(DataKTP data) {
        this.setTitle("Input Data");
        this.setBounds(400, 200, 1024, 768);
        this.setLocationRelativeTo(null);

        JPanel c = new JPanel(new GridBagLayout()); // Gunakan GridBagLayout di panel utama
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 20, 20, 0);

        // Header label
        JLabel header = new JLabel("Republik Harapan Bangsa");
        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.add(header, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        c.add(createLeftLayout(data), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        c.add(createRightLayout(data), gbc);

        this.add(c);
        this.setVisible(true);
    }


    public JPanel createLeftLayout(DataKTP d) {
        JPanel lc = new JPanel(new GridBagLayout());
        GridBagConstraints gbl = new GridBagConstraints();
        gbl.insets = new Insets(0, 15, 15, 0);
        gbl.anchor = GridBagConstraints.WEST;
        gbl.fill = GridBagConstraints.HORIZONTAL;

        gbl.gridx = 0;
        gbl.gridy = 0;
        lc.add(show.createTextPanel(d.getNik(), "NIK : "), gbl);

        gbl.gridy++;  // Naikkan baris untuk elemen berikutnya
        lc.add(show.createTextPanel(d.getNama(), "Nama : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getTempatLahir() + ", " + d.getTanggalLahir(), "Tempat/Tgl Lahir : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getJenisKelamin().toString(), "Jenis Kelamin : "), gbl);

        gbl.gridx = 1;
        lc.add(show.createTextPanel(d.getGolonganDarah().toString(), "Golongan Darah : "), gbl);

        gbl.gridx = 0;
        gbl.gridy++;
        lc.add(show.createTextPanel(d.getAlamat(), "Alamat : "), gbl);

        gbl.gridy++;
        gbl.insets = new Insets(0, 40, 15, 0);  // Ubah sedikit padding
        lc.add(show.createTextPanel(d.getRtRw(), "RT/RW : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getKelDesa(), "Kel/Desa : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getKecamatan(), "Kecamatan : "), gbl);

        gbl.gridy++;
        gbl.insets = new Insets(0, 15, 15, 0);
        lc.add(show.createTextPanel(d.getAgama().toString(), "Agama : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getStatus().toString(), "Status Perkawinan : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getPekerjaan(), "Pekerjaan : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getKewarganegaraan(), "Kewarganegaraan : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getBerlakuHingga(), "Berlaku Hingga : "), gbl);

        return lc;
    }

    public JPanel createRightLayout(DataKTP d) {
        JPanel rc = new JPanel(new GridBagLayout());
        GridBagConstraints gbr = new GridBagConstraints();
        gbr.insets = new Insets(15, 15, 15, 15);
        gbr.anchor = GridBagConstraints.CENTER;
        gbr.fill = GridBagConstraints.HORIZONTAL;

        gbr.gridx = 0;
        gbr.gridy = 0;
        rc.add(img.createShowImage(d.getFoto(), "pasFoto"), gbr);

        gbr.gridy++;
        rc.add(show.createTextPanel(d.getKotaPembuatanKTP(), ""), gbr);

        gbr.gridy++;
        rc.add(show.createTextPanel(d.getTanggalPembuatanKTP().toString(), ""), gbr);

        gbr.gridy++;
        rc.add(img.createShowImage(d.getTandaTangan(), "ttd"), gbr);

        return rc;
    }
}
