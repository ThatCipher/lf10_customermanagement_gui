package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeEditEntryController {

    Employee employee;
    FXMLLoader fxmlLoader;

    @FXML
    public TextField txt_firstName;
    @FXML
    public TextField txt_lastName;
    @FXML
    public TextField txt_streetName;
    @FXML
    public TextField txt_streetNumber;
    @FXML
    public TextField txt_city;
    @FXML
    public TextField txt_country;
    @FXML
    public TextField txt_plz;
    @FXML
    public TextField txt_email;
    @FXML
    public TextField txt_telephoneNumber;

    public EmployeeEditEntryController(Employee employee) {
        this.employee = employee;
        System.out.println(this.employee.getFirstname());
        initView();
        initData();
    }

    public void initView() {
        fxmlLoader = new FXMLLoader(getClass().getResource("edit-employee-view.fxml"));
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initData(){
        txt_firstName.setText(employee.getFirstname());
        txt_lastName.setText(employee.getLastname());
        txt_email.setText(employee.getEmail());
        txt_telephoneNumber.setText(employee.getTelephone());

        Address address = employee.getAddress();
        txt_streetName.setText(address.getStreet());
        txt_streetNumber.setText(address.getHouse());
        txt_city.setText(address.getCity());
        txt_plz.setText(address.getPostalCode());
        txt_country.setText(address.getCountry());
    }

    @FXML
    void saveChanges() {
        employee.setFirstname(txt_firstName.getText());
        employee.setLastname(txt_lastName.getText());
        employee.setEmail(txt_email.getText());
        employee.setTelephone(txt_telephoneNumber.getText());

        Address address = employee.getAddress();
        address.setStreet(txt_streetName.getText());
        address.setHouse(txt_streetNumber.getText());
        address.setPostalCode(txt_plz.getText());
        address.setCity(txt_city.getText());
        address.setCountry(txt_country.getText());

        CustomerManagementGUI.client.updateEmployee(employee);
    }
}
