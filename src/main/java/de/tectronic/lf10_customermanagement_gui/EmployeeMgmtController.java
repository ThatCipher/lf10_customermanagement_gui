package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
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

    @FXML
    void openNewEmployeeWindow(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("new-employee-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Auftragsverwaltung - Mitarbeiter hinzufügen");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    void openEditEmployeeWindow(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("edit-employee-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Auftragsverwaltung - Mitarbeiter bearbeiten");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
