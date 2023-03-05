package de.tectronic.lf10_customermanagement_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MgmtViewController {

    public Label lbl_username;
    public Label lbl_title;

    public Button btn_employee;
    public Button btn_customer;
    public Button btn_contract;

    public HBox hbx_list;

    @FXML
    public void initialize(){
        updateLoggedUser();
        setMode(MANAGEMENT_MODE.EMPLOYEE);
    }

    void updateLoggedUser(){
        // Imagine fetching real userdata
        lbl_username.setText("Max Mustermann");
    }

    public void activateCustomer(){setMode(MANAGEMENT_MODE.CUSTOMER);}
    public void activateContract(){setMode(MANAGEMENT_MODE.CONTRACT);}
    public void activateEmployee(){setMode(MANAGEMENT_MODE.EMPLOYEE);}


    void setMode(MANAGEMENT_MODE mode) {
        btn_customer.setDisable(false);
        btn_employee.setDisable(false);
        btn_contract.setDisable(false);
        hbx_list.getChildren().clear();

        switch (mode) {
            case CONTRACT -> {
                btn_contract.setDisable(true);

                lbl_title.setText("Auftragsverwaltung");

                System.out.println("Contract Mode");
            }
            case EMPLOYEE -> {
                btn_employee.setDisable(true);

                EmployeeListComponentController employeeViewController = new EmployeeListComponentController();
                hbx_list.getChildren().add(employeeViewController);
                lbl_title.setText("Mitarbeiterverwaltung");

                System.out.println("Employee Mode");
            }
            case CUSTOMER -> {
                btn_customer.setDisable(true);

                CustomerListComponentController customerListComponentController = new CustomerListComponentController();
                hbx_list.getChildren().add(customerListComponentController);
                lbl_title.setText("Kundenverwaltung");

                System.out.println("Customer Mode");
            }

            default -> {
                btn_customer.setDisable(true);
                btn_customer.setDisable(true);
                btn_contract.setDisable(true);
            }
        }
    }

}

enum MANAGEMENT_MODE {
    EMPLOYEE,
    CUSTOMER,
    CONTRACT
}