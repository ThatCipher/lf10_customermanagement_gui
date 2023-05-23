package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.Address;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class CustomerEditorController {

    HaseGmbHManagement mgmt = new HaseGmbHManagement();
    Customer currentCustomer;

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


    // bei Start der "Eintrag bearbeiten"-View vom Kunden ausführen:
    public void showCustomer(Customer c) {

        currentCustomer = c;

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

    void saveChanges() {

        mgmt.updateCustomer(currentCustomer);

        l_customerName.setText(currentCustomer.getFirstname() + currentCustomer.getLastname());
        l_customerID.setText("" + currentCustomer.getCustomerID());
    }

    void deleteEntry() {
        mgmt.deleteCustomer(currentCustomer.getCustomerID());
    }

    void exitForm() {
        // Ansicht ausmachen, wie auch immer das geht xd
    }

    @FXML
    void editName() {
        currentCustomer.setFirstname(tf_customerFirstname.getText());
        currentCustomer.setLastname(tf_customerLastname.getText());
    }
    @FXML
    void editID() {
        currentCustomer.setCustomerID(Integer.parseInt(tf_customerID.getText()));
    }
    @FXML
    void editBirthday() {
        currentCustomer.setBirthday(LocalDate.parse(tf_customerBirthday.getText()));
    }
    @FXML
    void editEmail() {
        currentCustomer.setEmail(tf_customerEmail.getText());
    }
    @FXML
    void editAddress() {

        Address currentAddress = currentCustomer.getAddress();

        currentAddress.setStreet(tf_addressStreet.getText());
        currentAddress.setHouse(tf_addressHouse.getText());
        currentAddress.setPostalCode(tf_addressPostalCode.getText());
        currentAddress.setCity(tf_addressCity.getText());
        currentAddress.setCountry(tf_addressCountry.getText());
    }

    // Parameter 1 for NEXT
    // Parameter -1 for LAST
    void switchCustomer(int dir) {
        showCustomer(mgmt.getAllCustomers().get(currentCustomer.getCustomerID()+dir));
    }

}
