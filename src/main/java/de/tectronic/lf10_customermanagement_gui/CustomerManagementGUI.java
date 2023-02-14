package de.tectronic.lf10_customermanagement_gui;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerManagementGUI extends Application {

    public static HaseGmbHManagement client;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerManagementGUI.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Auftragsverwaltung Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        client = new HaseGmbHManagement();
        launch();
    }
}