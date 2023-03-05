package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    public Button btn_addEmployee;
    HaseGmbHManagement haseGmbHManagement = new HaseGmbHManagement();
    @FXML
    void addEmployee() {
        System.out.println(haseGmbHManagement.getAllEmployees().size());

        Address address = new Address(txt_streetName.getText(), txt_streetNumber.getText(), txt_plz.getText(), txt_city.getText(), txt_country.getText());
        haseGmbHManagement.addNewEmployee(new Employee(txt_firstName.getText(), txt_lastName.getText(), address, txt_email.getText(), txt_telephoneNumber.getText()));

        System.out.println(haseGmbHManagement.getAllEmployees().size());

        System.out.println(haseGmbHManagement.getAllEmployees());
    }
}
