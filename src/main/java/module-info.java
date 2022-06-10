module cdt.poo.checkpoint {
    requires javafx.controls;
    requires javafx.fxml;


    opens ctd.poo.checkpoint to javafx.fxml;
    exports ctd.poo.checkpoint;
    exports ctd.poo.checkpoint.controller;
    opens ctd.poo.checkpoint.controller to javafx.fxml;
}