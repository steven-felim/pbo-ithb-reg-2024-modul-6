package view.panels;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import static view.panels.Panel.createPanel;

public class InputDate {
    public JDatePanelImpl createDatePanel() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl panel = new JDatePanelImpl(model, p);
        return panel;
    }

    public JDatePanelImpl createDatePanel(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();

        model.setDate(calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
        model.setSelected(true);

        JDatePanelImpl panel = new JDatePanelImpl(model, p);
        return panel;
    }

    public JPanel createInputDatePanel(JDatePickerImpl date, String labelText) {
        JPanel panel = createPanel(labelText);
        panel.add(date);
        return panel;
    }
}
