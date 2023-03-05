package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public TextField txt_username;
    public PasswordField pwd_password;

    @FXML
    void onclick(){
        System.out.println(txt_username.getText());
        System.out.println(pwd_password.getText());
    }

    @FXML
    void tryLogin(ActionEvent event) {
        String username = txt_username.getText();
        String password = pwd_password.getText();
        if(username.isEmpty() || password.isEmpty()){
            showEmptyFieldAlert();
            return;
        }
        if(username.equals("demo")){
            if(password.equals("user")){
                openManagementWindow();
                Util.closeWindow(event);
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

    void openManagementWindow() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mgmtView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Auftragsverwaltung - eingeloggt als Demo");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}