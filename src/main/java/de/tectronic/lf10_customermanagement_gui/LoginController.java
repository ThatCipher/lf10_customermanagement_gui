package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    public TextField txt_username;
    public PasswordField pwd_password;

    @FXML
    void onclick(){
        System.out.println(txt_username.getText());
        System.out.println(pwd_password.getText());
    }

    @FXML
    void tryLogin(){
        String username = txt_username.getText();
        String password = pwd_password.getText();
        if(username.isEmpty() || password.isEmpty()){
            showEmptyFieldAlert();
            return;
        }
        if(username.equals("demo")){
            if(password.equals("user")){
                System.out.println("SUCESSFULL");
                return;
            }
        }
        unknownUserAlert();
    }

    void showEmptyFieldAlert(){
        Alert emptyAlert = new Alert(Alert.AlertType.WARNING);
        emptyAlert.setTitle("Leeres Feld!");
        emptyAlert.setHeaderText(null);
        emptyAlert.setContentText("Eines oder mehrere Eingabefelder wurden nicht ausgefüllt.");
        emptyAlert.showAndWait();
    }

    void unknownUserAlert(){
        Alert emptyAlert = new Alert(Alert.AlertType.ERROR);
        emptyAlert.setTitle("Falscher Login!");
        emptyAlert.setHeaderText(null);
        emptyAlert.setContentText("Angegeber Nutzername oder Password nicht gefunden.");
        emptyAlert.showAndWait();
    }
}