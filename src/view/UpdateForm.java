package view;

import controller.GetData;
import controller.SaveData;
import controller.UpdateData;
import controller.Validator;
import model.classes.DataKTP;
import model.classes.DateLabelFormatter;
import org.jdatepicker.impl.JDatePickerImpl;
import view.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

public class UpdateForm extends JFrame implements ActionListener {
    private JButton buttonUpdate;
    private static DataKTP tempData;
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

    Map<String, Object> allInput = new HashMap<>();

    public UpdateForm(String nik) {
        GetData dataFromDB = new GetData();
        tempData = dataFromDB.fetchDataFromDB(nik);

        initComponents();
    }

    private void initComponents() {
        this.setTitle("Update Data Screen");
        this.setBounds(400, 200, 1024, 768);
        this.setLocationRelativeTo(null);

        JPanel c = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 40);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        fNik = new JTextField(tempData.getNik(), 20);

        c.add(input.createInputTextPanel(fNik, "NIK : "), gbc);

        gbc.gridx++;
        fNama = new JTextField(tempData.getNama(), 20);
        c.add(input.createInputTextPanel(fNama, "Nama : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fTempatLahir = new JTextField(tempData.getTempatLahir(), 20);
        c.add(input.createInputTextPanel(fTempatLahir, "Tempat Lahir : "), gbc);

        gbc.gridx++;
        fTanggalLahir = new JDatePickerImpl(date.createDatePanel(tempData.getTanggalLahir()), new DateLabelFormatter());
        c.add(date.createInputDatePanel(fTanggalLahir, "Tanggal Lahir : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        c.add(radio.createRadGender("Gender : ", tempData.getJenisKelamin().toString()), gbc);

        gbc.gridx++;
        c.add(radio.createRadGolDarah("Golongan Darah : ", tempData.getGolonganDarah().toString()), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fAlamat = new JTextField(tempData.getAlamat(), 20);
        c.add(input.createInputTextPanel(fAlamat, "Alamat : "), gbc);

        gbc.gridx++;
        fRtRw = new JTextField(tempData.getRtRw(), 20);
        c.add(input.createInputTextPanel(fRtRw, "RT/RW : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fKelDesa = new JTextField(tempData.getKelDesa(), 20);
        c.add(input.createInputTextPanel(fKelDesa, "Kel/Desa : "), gbc);

        gbc.gridx++;
        fKecamatan = new JTextField(tempData.getKecamatan(), 20);
        c.add(input.createInputTextPanel(fKecamatan, "Kecamatan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        c.add(comboBox.createInputComboBoxAgama("Agama : ", tempData.getAgama()), gbc);

        gbc.gridx++;
        c.add(comboBox.createInputComboBoxStatusKawin("Status Perkawinan : ", tempData.getStatus()), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        c.add(checkBox.createCheckBoxPekerjaan("Pekerjaan : ", tempData.getPekerjaan()), gbc);

        gbc.gridy++;
        c.add(radio.createRadWN("Kewarganegaraan : ", tempData.getKewarganegaraan()), gbc);

        gbc.gridy++;
        File choosenFileF = new File(tempData.getFoto());
        fcFoto = new JFileChooser();
        fcFoto.setSelectedFile(choosenFileF);
        c.add(fileChooser.createFileChooserFoto(fcFoto, "Foto : ", tempData), gbc);

        gbc.gridy++;
        File choosenFileT = new File(tempData.getTandaTangan());
        fcTtd = new JFileChooser();
        fcTtd.setSelectedFile(choosenFileT);
        c.add(fileChooser.createFileChooserTtd(fcTtd, "Tanda Tangan : ", tempData), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        fKotaPembuatanKtp = new JTextField(tempData.getKotaPembuatanKTP(), 20);
        c.add(input.createInputTextPanel(fKotaPembuatanKtp, "Kota Pembuatan KTP : "), gbc);

        gbc.gridx++;
        fTanggalPembuatanKTP = new JDatePickerImpl(date.createDatePanel(tempData.getTanggalPembuatanKTP()), new DateLabelFormatter());
        c.add(date.createInputDatePanel(fTanggalPembuatanKTP, "Tanggal Pembuatan KTP : "), gbc);

        buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(10, 100, 200, 40);
        buttonUpdate.addActionListener(this);
        buttonUpdate.setEnabled(true);
        buttonUpdate.setVisible(true);

        gbc.gridy++;
        gbc.gridx--;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        c.add(buttonUpdate, gbc);

        JScrollPane scrollPane = new JScrollPane(c);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userInputText = new HashMap<>();
        userInputDate = new HashMap<>();
        userInputRadio = new HashMap<>();
        userInputComboBox = new HashMap<>();
        userInputFileChooser = new HashMap<>();
        onUpdate();
    }

    private void onUpdate() {
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
            UpdateData update = new UpdateData();
            new Hasil(update.updateToDatabase(allInput), fNik.getText());
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