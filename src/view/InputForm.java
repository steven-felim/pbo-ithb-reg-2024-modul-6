package view;

import javax.swing.*;

import controller.Validator;
import model.classes.DataKTP;
import model.classes.DateLabelFormatter;
import org.jdatepicker.impl.*;
import view.panels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;

public class InputForm extends JFrame implements ActionListener {
    private JButton submit;
    private DataKTP data = new DataKTP();
    private Validator validator = new Validator();

    private InputPanel input = new InputPanel();
    private InputDate date = new InputDate();
    private InputRadio radio = new InputRadio();
    private InputComboBox comboBox = new InputComboBox();
    private InputCheckBox checkBox = new InputCheckBox();
    private FileChooser fileChooser = new FileChooser();

    private JTextField fNik, fNama, fTempatLahir, fAlamat, fRtRw, fKelDesa, fKecamatan, fBerlakuHingga, fKotaPembuatanKtp, fWNA;
    private JDatePickerImpl fTanggalLahir, fTanggalPembuatanKTP;
    private JFileChooser fcFoto, fcTtd;

    public InputForm() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Input Data");
        this.setBounds(400, 200, 1024, 768);
        this.setLocationRelativeTo(null);

        JPanel c = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 40);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        fNik = new JTextField(16);
        c.add(input.createInputTextPanel(fNik, "NIK : "), gbc);

        gbc.gridx++;
        fNama = new JTextField(20);
        c.add(input.createInputTextPanel(fNama, "Nama : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fTempatLahir = new JTextField(20);
        c.add(input.createInputTextPanel(fTempatLahir, "Tempat Lahir : "), gbc);

        gbc.gridx++;
        fTanggalLahir = new JDatePickerImpl(date.createDatePanel(), new DateLabelFormatter());
        c.add(date.createInputDatePanel(fTanggalLahir, "Tanggal Lahir : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        c.add(radio.createRadGender("Jenis Kelamin : "), gbc);

        gbc.gridx++;
        c.add(radio.createRadGolDarah("Golongan Darah : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fAlamat = new JTextField(20);
        c.add(input.createInputTextPanel(fAlamat, "Alamat : "), gbc);

        gbc.gridx++;
        fRtRw = new JTextField(20);
        c.add(input.createInputTextPanel(fRtRw, "RT/RW : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fKelDesa = new JTextField(20);
        c.add(input.createInputTextPanel(fKelDesa, "Kelurahan/Desa : "), gbc);

        gbc.gridx++;
        fKecamatan = new JTextField(20);
        c.add(input.createInputTextPanel(fKecamatan, "Kecamatan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        c.add(comboBox.createInputComboBoxAgama("Agama : "), gbc);

        gbc.gridx++;
        c.add(comboBox.createInputComboBoxStatusKawin("Status Perkawinan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth = 2;
        c.add(checkBox.createCheckBoxPekerjaan("Pekerjaan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        c.add(radio.createRadWN("Kewarganegaraan : "), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        fcFoto = new JFileChooser();
        c.add(fileChooser.createFileChooserFoto(fcFoto, "Foto : ", data), gbc);

        gbc.gridy++;
        fcTtd = new JFileChooser();
        c.add(fileChooser.createFileChooserTtd(fcTtd, "Tanda Tangan : ", data), gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        fBerlakuHingga = new JTextField(20);
        c.add(input.createInputTextPanel(fBerlakuHingga, "Berlaku hingga : "), gbc);

        gbc.gridy++;
        fKotaPembuatanKtp = new JTextField(20);
        c.add(input.createInputTextPanel(fKotaPembuatanKtp, "Kota Pembuatan KTP : "), gbc);

        gbc.gridy++;
        fTanggalPembuatanKTP = new JDatePickerImpl(date.createDatePanel(), new DateLabelFormatter());
        c.add(date.createInputDatePanel(fTanggalPembuatanKTP, "Tanggal Pembuatan KTP : "), gbc);

        this.add(c);

        JScrollPane scrollPane = new JScrollPane(c);
        this.add(scrollPane);

        submit = new JButton("Submit!");
        submit.setBounds(10, 100, 200, 40);
        submit.addActionListener(this);
        submit.setEnabled(true);
        submit.setVisible(true);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        c.add(submit, gbc);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onSubmit();
    }

    private void onSubmit() {
        data.setNik(fNik.getText());
        data.setNama(fNama.getText());
        data.setTempatLahir(fTempatLahir.getText());
        data.setTanggalLahir((Date) fTanggalLahir.getModel().getValue());
        data.setJenisKelamin(radio.getSelectedGender());
        data.setGolonganDarah(radio.getSelectedGolonganDarah());
        data.setAlamat(fAlamat.getText());
        data.setRtRw(fRtRw.getText());
        data.setKelDesa(fKelDesa.getText());
        data.setKecamatan(fKecamatan.getText());
        data.setAgama(comboBox.getSelectedAgama());
        data.setStatus(comboBox.getSelectedStatusPerkawinan());
        data.setPekerjaan(checkBox.getSelectedPekerjaan());
        data.setKewarganegaraan(radio.getSelectedKewarganegaraan());
        data.setTandaTangan(fcTtd.getSelectedFile().getAbsolutePath());
        data.setBerlakuHingga(fBerlakuHingga.getText());
        data.setKotaPembuatanKTP(fKotaPembuatanKtp.getText());
        data.setTanggalPembuatanKTP((Date) fTanggalPembuatanKTP.getModel().getValue());

        boolean validSemua = validator.validateForm(data);
        if (validSemua) {
            new Hasil().HasilKTP(data);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Input Tidak Valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
