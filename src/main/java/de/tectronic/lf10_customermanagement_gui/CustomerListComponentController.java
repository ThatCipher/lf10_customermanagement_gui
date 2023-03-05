package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerListComponentController extends HBox {

    public ListView<Customer> lsv_customerList;

    ArrayList<Customer> customers = new ArrayList<>();
    ObservableList<Customer> customersObservableList;

    public CustomerListComponentController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerListComponent.fxml"));
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
        customers = CustomerManagementGUI.client.getAllCustomers();
        updateEmployeeList();
    }

    void updateEmployeeList(){
        if(customersObservableList == null){
            customersObservableList = FXCollections.observableArrayList();
        }

        customersObservableList.clear();
        customersObservableList.addAll(customers);

        lsv_customerList.setItems(customersObservableList);
        lsv_customerList.setCellFactory(employeeListView -> new CustomerListCellController());
    }

}
