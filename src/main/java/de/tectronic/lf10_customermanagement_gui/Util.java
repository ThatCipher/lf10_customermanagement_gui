package de.tectronic.lf10_customermanagement_gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Util {

    public static void closeWindow(ActionEvent event){
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public static boolean showConfirmationFieldAlert(){
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Löschen?");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Sicher, dass sie den Eintrag löschen wollen?");
        confirmationAlert.getButtonTypes().clear();
        confirmationAlert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        confirmationAlert.showAndWait();

        if (confirmationAlert.getResult() == ButtonType.YES) {
            return true;
        }
        return false;
    }

}
