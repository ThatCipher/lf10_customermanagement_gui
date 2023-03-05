package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CustomerListCellController extends ListCell<Customer> {

    @FXML
    public Label lbl_name;
    @FXML
    public Label lbl_mail;
    @FXML
    public Label lbl_address;
    @FXML
    public AnchorPane anchorPane;

    private FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(Customer customer, boolean empty){
        super.updateItem(customer, empty);

        if(empty || customer == null){
            setText(null);
            setGraphic(null);
        }

        else {
            if(fxmlLoader == null){
                loadFXML();
            }

            lbl_name.setText(customer.getFirstname() + " " + customer.getLastname());
            lbl_mail.setText(customer.getEmail());
            lbl_address.setText(createAddressString(customer));

            setText(null);
            setGraphic(anchorPane);
        }
    }

    private void loadFXML(){
        fxmlLoader = new FXMLLoader(getClass().getResource("customerListCell.fxml"));
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private String createAddressString(Customer customer) {
        Address address = customer.getAddress();
        return address.getStreet() + " " + address.getHouse() + ", " + address.getPostalCode() + " " + address.getCity();
    }

}
