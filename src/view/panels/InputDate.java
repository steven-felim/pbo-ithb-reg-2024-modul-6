package view.panels;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.util.Properties;

import static view.panels.Panel.createPanel;

public class InputDate {
    public JDatePanelImpl createDatePanel() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl panel = new JDatePanelImpl(model, p);
        return panel;
    }

    public JPanel createInputDatePanel(JDatePickerImpl date, String labelText) {
        JPanel panel = createPanel(labelText);
        panel.add(date);
        return panel;
    }
}
