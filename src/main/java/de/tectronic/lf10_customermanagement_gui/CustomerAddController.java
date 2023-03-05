package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.Address;
import java.time.LocalDate;
import javafx.fxml.FXML;
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

    @FXML
    void saveChanges() {
        Address newAddress = new Address(tf_addressStreet.getText(), tf_addressHouse.getText(), tf_addressPostalCode.getText(), tf_addressCity.getText(), tf_addressCountry.getText());
        Customer newCustomer = new Customer(tf_customerFirstname.getText(), tf_customerLastname.getText(), LocalDate.parse(tf_customerBirthday.getText()), tf_customerEmail.getText(), newAddress);
        Customer addedCustomer;

        mgmt.addNewCustomer(newCustomer);
        addedCustomer = mgmt.getCustomer(mgmt.getAllCustomers().size());
        l_customerName.setText(addedCustomer.getFirstname() + addedCustomer.getLastname());
        l_customerID.setText("" + addedCustomer.getCustomerID());
    }

    void exitForm() {
        // Ansicht ausmachen, wie auch immer das geht xd
    }
}
