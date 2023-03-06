package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeNewEntryController {
    FXMLLoader fxmlLoader;

    public BorderPane bp_root;
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

    public EmployeeNewEntryController() {
        fxmlLoader = new FXMLLoader(getClass().getResource("new-employee-view.fxml"));
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    @FXML
    void addEmployee() {
        Address address = new Address(
                txt_streetName.getText(),
                txt_streetNumber.getText(),
                txt_plz.getText(),
                txt_city.getText(),
                txt_country.getText()
        );

        Employee employee = new Employee(
                txt_firstName.getText(),
                txt_lastName.getText(),
                address,
                txt_email.getText(),
                txt_telephoneNumber.getText()
        );

        CustomerManagementGUI.client.addNewEmployee(employee);

        Stage stage = (Stage) bp_root.getScene().getWindow();
        stage.close();
    }
}
