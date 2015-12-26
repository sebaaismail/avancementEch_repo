package com.sebaainf.avcmtApp;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.util.Properties;

/**
 * Created by INFO on 01/12/2015.
 */
public class SitAvcmtEch_datePicker extends JDatePickerImpl {

    public SitAvcmtEch_datePicker(JDatePanelImpl datePanel, JFormattedTextField.AbstractFormatter formatter) {
        super(datePanel, formatter);
    }

    /*public SitAvcmtEch_datePicker(String propertyName) {

        UtilDateModel dateModel = new UtilDateModel();

        //dateModel.setDate(2000, 01, 01);

        Properties p = new Properties();
        *//*p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");*//*

        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);


        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, formatter);

        datePicker.setShowYearButtons(true);
        datePicker.setButtonFocusable(true);
        datePicker.setTextEditable(true);
        datePicker.getJFormattedTextField().setHorizontalAlignment(JTextField.RIGHT);
        datePicker = initializeDatePicker(datePicker, model, datePropertyName);



    }*/
}
