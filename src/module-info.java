module TrabalhoPOO { 
    requires javafx.controls;
    requires javafx.fxml;

    opens run to javafx.fxml; 
    exports run; 
}
