module de.tectronic.lf10_customermanagement_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.tectronic.lf10_customermanagement_gui to javafx.fxml;
    exports de.tectronic.lf10_customermanagement_gui;
    opens de.tectronic.lf10_customermanagement_gui.views.customer to javafx.fxml;
    exports de.tectronic.lf10_customermanagement_gui.views.customer;
    opens de.tectronic.lf10_customermanagement_gui.views.employee to javafx.fxml;
    exports de.tectronic.lf10_customermanagement_gui.views.employee;
    opens de.tectronic.lf10_customermanagement_gui.views to javafx.fxml;
    exports de.tectronic.lf10_customermanagement_gui.views;
}