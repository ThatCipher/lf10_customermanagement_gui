package de.tectronic.lf10_customermanagement_gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EmployeeNewEntryController {
    public TextField txt_firstName;
    public TextField txt_lastName;
    public TextField txt_streetName;
    public TextField txt_streetNumber;
    public TextField txt_city;
    public TextField txt_country;
    public TextField txt_plz;
    public TextField txt_email;
    public TextField txt_telephoneNumber;

    @FXML
    void addNewEmployee() {
        // CustomerManagementGUI.client.addNewEmployee(txt_firstName.getText() + txt_lastName.getText());
        System.out.println(txt_streetName.getText());
        System.out.println(txt_streetNumber.getText());
        System.out.println(txt_city.getText());
        System.out.println(txt_country.getText());
        System.out.println(txt_plz.getText());
        System.out.println(txt_email.getText());
        System.out.println(txt_telephoneNumber.getText());
    }
}
