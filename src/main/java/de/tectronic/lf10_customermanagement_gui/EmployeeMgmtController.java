package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class EmployeeMgmtController {

    public Label lbl_username;
    public ListView<Employee> lsv_employeeList;

    ArrayList<Employee> employees = new ArrayList<>();
    ObservableList<Employee> employeeObservableList;

    @FXML
    public void initialize(){
        updateLoggedUser();
        employees = CustomerManagementGUI.client.getAllEmployees();
        updateEmployeeList();
    }

    void updateLoggedUser(){
        // Imagine fetching real userdata
        lbl_username.setText("Max Mustermann");
    }

    void updateEmployeeList(){
        if(employeeObservableList == null){
            employeeObservableList = FXCollections.observableArrayList();
        }

        employeeObservableList.clear();
        employeeObservableList.addAll(employees);

        lsv_employeeList.setItems(employeeObservableList);
        lsv_employeeList.setCellFactory(employeeListView -> new EmployeeListCellController());
    }

}
