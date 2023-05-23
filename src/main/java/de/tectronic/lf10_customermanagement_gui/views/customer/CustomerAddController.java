package de.tectronic.lf10_customermanagement_gui.views.customer;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.Address;

import java.io.IOException;
import java.time.LocalDate;

import de.tectronic.lf10_customermanagement_gui.interfaces.ICustomerCallback;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class CustomerAddController {

    HaseGmbHManagement mgmt = new HaseGmbHManagement();

    // Labels
    public Label l_customerName;
    public Label l_customerID;

    // TextFields - Customer
    public TextField tf_customerFirstname;
    public TextField tf_customerLastname;
    public TextField tf_customerID;
    public TextField tf_customerBirthday;
    public TextField tf_customerEmail;

    // TextFields - Address
    public TextField tf_addressStreet;
    public TextField tf_addressHouse;
    public TextField tf_addressCity;
    public TextField tf_addressPostalCode;
    public TextField tf_addressCountry;

    ICustomerCallback callback;

    public CustomerAddController () {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer-add.fxml"));
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setCallback(ICustomerCallback callback) {
        this.callback = callback;
    }

    @FXML
    void saveChanges() {
        Address newAddress = new Address(tf_addressStreet.getText(), tf_addressHouse.getText(), tf_addressPostalCode.getText(), tf_addressCity.getText(), tf_addressCountry.getText());
        Customer newCustomer = new Customer(tf_customerFirstname.getText(), tf_customerLastname.getText(), LocalDate.parse(tf_customerBirthday.getText()), tf_customerEmail.getText(), newAddress);
        Customer addedCustomer;

        mgmt.addNewCustomer(newCustomer);
        addedCustomer = mgmt.getCustomer(mgmt.getAllCustomers().size());
        l_customerName.setText(addedCustomer.getFirstname() + addedCustomer.getLastname());
        l_customerID.setText("" + addedCustomer.getCustomerID());

        exitForm();
    }

    void FillCustomerFields(Customer c) {
        // fill Customer Fields
        tf_customerID.setText("" + c.getCustomerID());
        l_customerID.setText(tf_customerID.getText());

        tf_customerFirstname.setText(c.getFirstname());
        tf_customerLastname.setText(c.getLastname());
        l_customerName.setText(tf_customerFirstname.getText() + tf_customerLastname.getText());

        tf_customerBirthday.setText("" + c.getBirthday());
        tf_customerEmail.setText(c.getEmail());

        // fill Address Fields
        Address customerAddress = c.getAddress();

        tf_addressStreet.setText(customerAddress.getStreet());
        tf_addressHouse.setText(customerAddress.getHouse());
        tf_addressCity.setText(customerAddress.getCity());
        tf_addressPostalCode.setText(customerAddress.getPostalCode());
        tf_addressCountry.setText(customerAddress.getCountry());
    }

    void exitForm() {
        // Ansicht ausmachen, wie auch immer das geht xd
    }
}
