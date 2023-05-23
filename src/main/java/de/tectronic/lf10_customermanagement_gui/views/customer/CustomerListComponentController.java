package de.tectronic.lf10_customermanagement_gui.views.customer;

import de.oszimt.lf10aContractMgmt.model.Customer;
import de.tectronic.lf10_customermanagement_gui.CustomerManagementGUI;
import de.tectronic.lf10_customermanagement_gui.Util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerListComponentController extends HBox {

    public ListView<Customer> lsv_customerList;

    ArrayList<Customer> customers = new ArrayList<>();
    ObservableList<Customer> customersObservableList;

    public CustomerListComponentController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/tectronic/lf10_customermanagement_gui/views/customer/customerListComponent.fxml"));
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

        lsv_customerList.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.DELETE) {
                deleteItem();
            }
        });
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

    @FXML
    void deleteItem(){
        if(lsv_customerList.getSelectionModel().getSelectedItem() == null){
            return;
        }

        boolean confirms = Util.showConfirmationFieldAlert();
        if(confirms) {
            int customerID = lsv_customerList.getSelectionModel().getSelectedItem().getCustomerID();
            CustomerManagementGUI.client.deleteCustomer(customerID);

            Customer selectedCustomer = lsv_customerList.getSelectionModel().getSelectedItem();
            lsv_customerList.getItems().remove(selectedCustomer);
        }
    }

}
