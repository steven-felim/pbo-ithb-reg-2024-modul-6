package view;

import controller.GetData;
import model.classes.DataKTP;
import view.panels.ShowImage;
import view.panels.ShowText;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Hasil extends JFrame implements ActionListener {
    private DataKTP data;
    private ShowText show = new ShowText();
    private ShowImage img = new ShowImage();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Hasil(boolean isSuccess, String NIK) {
        if (!isSuccess) {
            JOptionPane.showMessageDialog(null, "Task Failed !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            GetData dataFromDB = new GetData();
            data = dataFromDB.fetchDataFromDB(NIK);

            initComponents();
        }
    }

    private void initComponents() {
        this.setTitle("Input Data");
        this.setBounds(400, 200, 1024, 768);
        this.setLocationRelativeTo(null);

        JPanel c = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 20, 20, 0);

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

        JButton submit = new JButton("Main Menu");
        submit.setBounds(10, 100, 200, 40);
        submit.addActionListener(this);
        submit.setEnabled(true);
        submit.setVisible(true);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        c.add(submit, gbc);

        this.add(c);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getNama(), "Nama : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getTempatLahir() + ", " + sdf.format(d.getTanggalLahir()), "Tempat/Tgl Lahir : "), gbl);

        gbl.gridy++;
        lc.add(show.createTextPanel(d.getJenisKelamin().toString(), "Jenis Kelamin : "), gbl);

        gbl.gridx = 1;
        lc.add(show.createTextPanel(d.getGolonganDarah().toString(), "Golongan Darah : "), gbl);

        gbl.gridx = 0;
        gbl.gridy++;
        lc.add(show.createTextPanel(d.getAlamat(), "Alamat : "), gbl);

        gbl.gridy++;
        gbl.insets = new Insets(0, 40, 15, 0);
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
        rc.add(img.createShowImage("D:\\#ITHB Semester 3\\Ganjil 2024 - Praktikum Pemrograman Berorientasi Objek\\20241129\\pbo-ithb-reg-2024-modul-6\\src\\img\\" + d.getFoto(), "pasFoto"), gbr);

        gbr.gridy++;
        rc.add(show.createTextPanel(d.getKotaPembuatanKTP(), " "), gbr);

        gbr.gridy++;
        rc.add(show.createTextPanel(sdf.format(d.getTanggalPembuatanKTP()), " "), gbr);

        gbr.gridy++;
        rc.add(img.createShowImage("D:\\#ITHB Semester 3\\Ganjil 2024 - Praktikum Pemrograman Berorientasi Objek\\20241129\\pbo-ithb-reg-2024-modul-6\\src\\img\\" + d.getTandaTangan(), "ttd"), gbr);

        return rc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onSubmit();
    }

    private void onSubmit() {
        new Menu();
        this.dispose();
    }
}
