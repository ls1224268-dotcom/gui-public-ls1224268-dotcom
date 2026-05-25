module blankjavafx.finalprojectfx5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens blankjavafx.finalprojectfx5 to javafx.fxml;
    exports blankjavafx.finalprojectfx5;
}