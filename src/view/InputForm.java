package view;

import javax.swing.*;

import controller.SaveData;
import controller.Validator;
import model.classes.DataKTP;
import model.classes.DateLabelFormatter;
import org.jdatepicker.impl.*;
import view.panels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

public class InputForm extends JFrame implements ActionListener {
    private final DataKTP data = new DataKTP();
    private final Validator validator = new Validator();

    private final InputPanel input = new InputPanel();
    private final InputDate date = new InputDate();
    private final InputRadio radio = new InputRadio();
    private final InputComboBox comboBox = new InputComboBox();
    private final InputCheckBox checkBox = new InputCheckBox();
    private final FileChooser fileChooser = new FileChooser();

    private JTextField fNik, fNama, fTempatLahir, fAlamat, fRtRw, fKelDesa, fKecamatan, fBerlakuHingga, fKotaPembuatanKtp;
    private JDatePickerImpl fTanggalLahir, fTanggalPembuatanKTP;
    private JFileChooser fcFoto, fcTtd;

    Map<String, String> userInputText, userInputRadio, userInputComboBox;
    Map<String, Date> userInputDate;
    Map<String, File> userInputFileChooser;

    Map<String,Object> allInput = new HashMap<>();

    public InputForm() {
        userInputText = new HashMap<>();
        userInputDate = new HashMap<>();
        userInputRadio = new HashMap<>();
        userInputComboBox = new HashMap<>();
        userInputFileChooser = new HashMap<>();
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

        JButton submit = new JButton("Submit!");
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
        inputMap();
        LinkedList<Boolean> isValid = new LinkedList<>();

        isValid.add(validator.validateText(userInputText));
        isValid.add(validator.validateDate(userInputDate));
        isValid.add(validator.validateRadio(userInputRadio, userInputText));
        isValid.add(validator.validateComboBox(userInputComboBox));
        isValid.add(validator.validateFileChooser(userInputFileChooser));
        isValid.add(validator.validateCheckBox(checkBox.pekerjaan, userInputText));

        boolean isReallyValid = true;

        Iterator<Boolean> iterator = isValid.iterator();
        while (iterator.hasNext() && isReallyValid) {
            isReallyValid = iterator.next();
        }

        allInput.putAll(userInputText);
        allInput.putAll(userInputDate);
        allInput.putAll(userInputRadio);
        allInput.putAll(userInputComboBox);
        allInput.putAll(userInputFileChooser);

        if (isReallyValid) {
            SaveData save = new SaveData();
            new Hasil(save.insertToDatabase(allInput), fNik.getText());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Input Tidak Valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inputMap() {
        userInputText.put("nik", fNik.getText());
        userInputText.put("nama", fNama.getText());
        userInputText.put("tempatLahir", fTempatLahir.getText());
        userInputText.put("alamat", fAlamat.getText());
        userInputText.put("rtRw", fRtRw.getText());
        userInputText.put("kelDesa", fKelDesa.getText());
        userInputText.put("kecamatan", fKecamatan.getText());
        userInputText.put("kotaPembuatanKtp", fKotaPembuatanKtp.getText());
        userInputText.put("additionalWNA", radio.fWNA.getText());

        userInputDate.put("tanggalLahir", (Date) fTanggalLahir.getModel().getValue());
        userInputDate.put("tanggalPembuatanKTP", (Date) fTanggalPembuatanKTP.getModel().getValue());

        userInputRadio.put("gender", radio.bGender.getSelection().getActionCommand());
        userInputRadio.put("golDar", radio.bGolDarah.getSelection().getActionCommand());
        userInputRadio.put("kewarganegaraan", radio.bKewarganegaraan.getSelection().getActionCommand());

        userInputComboBox.put("agama", comboBox.cAgama.getSelectedItem().toString());
        userInputComboBox.put("statusKawin", comboBox.cStatusKawin.getSelectedItem().toString());

        userInputFileChooser.put("fileFoto", fcFoto.getSelectedFile());
        userInputFileChooser.put("fileTandaTangan", fcTtd.getSelectedFile());
    }
}