package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        updateEmployees();
        updateEmployeeList();
    }

    public void updateEmployees() {
        employees.clear();
        employees = CustomerManagementGUI.client.getAllEmployees();
    }

    void updateEmployeeList(){
        if(employeeObservableList == null){
            employeeObservableList = FXCollections.observableArrayList();
        }

        employeeObservableList.clear();
        employeeObservableList.addAll(CustomerManagementGUI.client.getAllEmployees());

        lsv_employeeList.setItems(employeeObservableList);
        lsv_employeeList.setCellFactory(employeeListView -> new EmployeeListCellController());
    }

    @FXML
    void openNewWindow() {
        EmployeeNewEntryController employeeNewEntryController = new EmployeeNewEntryController();

        Stage stage = new Stage();
        stage.setTitle("Kunde erstellen");
        stage.setScene(new Scene(employeeNewEntryController.fxmlLoader.getRoot()));
        stage.show();
    }

    @FXML
    void openEditWindow() {
        if(lsv_employeeList.getSelectionModel().getSelectedItem() == null){
            return;
        }

        EmployeeEditEntryController employeeEditEntryController = new EmployeeEditEntryController(lsv_employeeList.getSelectionModel().getSelectedItem());

        Stage stage = new Stage();
        stage.setTitle("Kunde bearbeiten");
        stage.setScene(new Scene(employeeEditEntryController.fxmlLoader.getRoot()));
        stage.show();
    }
}
