package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeeListComponentController extends HBox {

    public ListView<Employee> lsv_employeeList;

    ArrayList<Employee> employees = new ArrayList<>();
    ObservableList<Employee> employeeObservableList;

    public EmployeeListComponentController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employeeListComponent.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void initialize(){
        employees = CustomerManagementGUI.client.getAllEmployees();
        updateEmployeeList();
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
