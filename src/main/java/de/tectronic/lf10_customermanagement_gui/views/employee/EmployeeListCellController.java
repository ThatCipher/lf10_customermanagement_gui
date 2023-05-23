package de.tectronic.lf10_customermanagement_gui.views.employee;

import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EmployeeListCellController extends ListCell<Employee> {

    @FXML
    public Label lbl_name;
    @FXML
    public Label lbl_phone;
    @FXML
    public Label lbl_mail;
    @FXML
    public AnchorPane anchorPane;

    private FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(Employee employee, boolean empty) {
        super.updateItem(employee, empty);

        if(empty || employee == null){
            setText(null);
            setGraphic(null);
        }
        else {
            if(fxmlLoader == null){
                loadFXML();
            }

            lbl_name.setText(employee.getFirstname() + " " + employee.getLastname());
            lbl_mail.setText(employee.getEmail());
            lbl_phone.setText(createPhoneString(employee));

            setText(null);
            setGraphic(anchorPane);
        }
    }

    private void loadFXML(){
        fxmlLoader = new FXMLLoader(getClass().getResource("employeeListCell.fxml"));
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private String createPhoneString(Employee employee){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < employee.getTelephone().length(); i++){
            temp.append(employee.getTelephone().charAt(i));
            if(i % 4 == 3){
                temp.append(" ");
            }
        }
        return temp.toString();
    }

    @FXML
    public void openEmployeeWindow(){
        // TODO
    }

}
