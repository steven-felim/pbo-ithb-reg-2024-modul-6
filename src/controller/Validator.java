package controller;

import javax.swing.*;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Validator {

    public boolean validateText(Map<String, String> userInputText) {
        boolean validating = true;

        Iterator<Map.Entry<String, String>> iteratorText = userInputText.entrySet().iterator();
        while (iteratorText.hasNext() && validating) {
            Map.Entry<String, String> entry = iteratorText.next();
            String textField = entry.getValue();

            if (textField.isEmpty()) {
                validating = false;
            }

            if (entry.getKey().equals("additionalWNA")) {
                validating = true;
            }
        }
        return validating;
    }

    public boolean validateDate(Map<String, Date> userInputDate) {
        boolean validating = true;

        Iterator<Date> iteratorDate = userInputDate.values().iterator();
        while (iteratorDate.hasNext() && validating) {
            Date dateField = iteratorDate.next();
            if (dateField == null) {
                validating = false;
            }
        }

        return validating;
    }

    public boolean validateRadio(Map<String, String> userInputRadio, Map<String, String> userInputText) {
        boolean validating = true;
        try {
            Iterator<String> iteratorRadio = userInputRadio.values().iterator();
            while (iteratorRadio.hasNext() && validating) {
                String groupField = iteratorRadio.next();

                if (groupField.equals("WNA") && userInputText.get("additionalWNA").isEmpty()) {
                    validating = false;
                } else if (groupField.equals("WNI")) {
                    userInputText.put("additionalWNA", "");
                    validating = true;
                }
            }
            return validating;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean validateComboBox(Map<String, String> userInputComboBox) {
        boolean validating = true;

        Iterator<String> iteratorComboBox = userInputComboBox.values().iterator();
        while (iteratorComboBox.hasNext() && validating) {
            String comboBoxField = iteratorComboBox.next();
            if (comboBoxField.isEmpty()) {
                validating = false;
            }
        }

        return validating;
    }

    public boolean validateCheckBox(List<JCheckBox> listPekerjaan, Map<String, String> all) {
        boolean validating = false;
        String pekerjaan = "";

        for (JCheckBox checkPekerjaan : listPekerjaan) {
            if (checkPekerjaan.getText().equals("Pengangguran") && listPekerjaan.get(4).isSelected()) {
                validating = true;
                break;
            } else {
                if (checkPekerjaan.isSelected()) {
                    validating = true;
                    break;
                }
            }
        }
        for (JCheckBox checkPekerjaan : listPekerjaan) {
            if (checkPekerjaan.isSelected()) {
                pekerjaan += checkPekerjaan.getText() + " ";
            }
        }

        all.put("pekerjaan", pekerjaan);
        return validating;
    }

    public boolean validateFileChooser(Map<String, File> userInputFileChooser) {
        boolean validating = true;

        Iterator<File> iteratorFile = userInputFileChooser.values().iterator();
        while (iteratorFile.hasNext() && validating) {
            File fileChooser = iteratorFile.next();
            if (fileChooser == null) {
                validating = false;
            }
        }

        return validating;
    }
}