package de.tectronic.lf10_customermanagement_gui.views.employee;

import de.oszimt.lf10aContractMgmt.model.Employee;
import de.tectronic.lf10_customermanagement_gui.CustomerManagementGUI;
import de.tectronic.lf10_customermanagement_gui.Util;
import de.tectronic.lf10_customermanagement_gui.interfaces.IEmployeeCallback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

        lsv_employeeList.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.DELETE) {
                deleteItem();
            }
        });
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

        employeeNewEntryController.setCallback(new IEmployeeCallback() {
            @Override
            public void onChange(Employee employee) {
                CustomerManagementGUI.client.addNewEmployee(employee);
                updateEmployeeList();
            }
        });

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

        employeeEditEntryController.setCallback(new IEmployeeCallback() {
            @Override
            public void onChange(Employee employee) {
                CustomerManagementGUI.client.updateEmployee(employee);
                updateEmployeeList();
            }
        });

        Stage stage = new Stage();
        stage.setTitle("Kunde bearbeiten");
        stage.setScene(new Scene(employeeEditEntryController.fxmlLoader.getRoot()));
        stage.show();
    }

    @FXML
    void deleteItem(){
        if(lsv_employeeList.getSelectionModel().getSelectedItem() == null){
            return;
        }

        boolean confirms = Util.showConfirmationFieldAlert();
        if(confirms) {
            int employeeID = lsv_employeeList.getSelectionModel().getSelectedItem().getEmployeeID();
            CustomerManagementGUI.client.deleteEmployee(employeeID);

            Employee selectedEmployee = lsv_employeeList.getSelectionModel().getSelectedItem();
            lsv_employeeList.getItems().remove(selectedEmployee);
        }
    }

}
