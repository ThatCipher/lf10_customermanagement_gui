module de.tectronic.lf10_customermanagement_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.tectronic.lf10_customermanagement_gui to javafx.fxml;
    exports de.tectronic.lf10_customermanagement_gui;
}