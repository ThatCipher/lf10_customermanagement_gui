package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeEditEntryController {
    // EmployeeListComponentController employeeListComponentController = new EmployeeListComponentController();
    HaseGmbHManagement haseGmbHManagement = new HaseGmbHManagement();
    Employee currentEmployee;

    public TextField txt_firstName;
    public TextField txt_lastName;
    public TextField txt_streetName;
    public TextField txt_streetNumber;
    public TextField txt_city;
    public TextField txt_country;
    public TextField txt_plz;
    public TextField txt_email;
    public TextField txt_telephoneNumber;
    public Button btn_editEmployee;

    public void showEmployee(Employee e) {
        currentEmployee = e;

        txt_firstName.setText(currentEmployee.getFirstname());
        txt_lastName.setText(currentEmployee.getLastname());
        txt_email.setText(currentEmployee.getEmail());
        txt_telephoneNumber.setText(currentEmployee.getTelephone());

        Address employeeAddress = currentEmployee.getAddress();
        txt_streetName.setText(employeeAddress.getStreet());
        txt_streetNumber.setText(employeeAddress.getHouse());
        txt_city.setText(employeeAddress.getCity());
        txt_plz.setText(employeeAddress.getPostalCode());
        txt_country.setText(employeeAddress.getCountry());
    }

    @FXML
    void saveChanges() {
        currentEmployee.setFirstname(txt_firstName.getText());
        currentEmployee.setLastname(txt_lastName.getText());
        currentEmployee.setEmail(txt_email.getText());
        currentEmployee.setTelephone(txt_telephoneNumber.getText());

        Address currentAddress = currentEmployee.getAddress();
        currentAddress.setStreet(txt_streetName.getText());
        currentAddress.setHouse(txt_streetNumber.getText());
        currentAddress.setPostalCode(txt_plz.getText());
        currentAddress.setCity(txt_city.getText());
        currentAddress.setCountry(txt_country.getText());

        haseGmbHManagement.updateEmployee((currentEmployee));
    }
}
