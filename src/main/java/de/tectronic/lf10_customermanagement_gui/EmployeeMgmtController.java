package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class EmployeeMgmtController {

    public Label lbl_username;
    public ListView<Employee> lsv_employeeList;

    @FXML
    public void initialize(){
        updateLoggedUser();
    }

    void updateLoggedUser(){
        // Imagine fetching real userdata
        lbl_username.setText("Max Mustermann");
    }

}
