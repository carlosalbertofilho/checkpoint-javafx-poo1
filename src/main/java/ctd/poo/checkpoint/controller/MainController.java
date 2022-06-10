package ctd.poo.checkpoint.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MainController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAuthor;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnInvoice;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnUser;

    @FXML
    private Button btnMainClose;

    @FXML
    private Text lbTitle;

    @FXML
    void handleAuthor(ActionEvent event) {
        if (event.getSource() == btnAuthor){
            lbTitle.setText("Créditos");
        }
    }

    @FXML
    void handleDashboard(ActionEvent event) {
        if (event.getSource() == btnDashboard){
            lbTitle.setText("Dashboard");
        }
    }

    @FXML
    void handleInvoice(ActionEvent event) {
        if (event.getSource() == btnInvoice){
            lbTitle.setText("Pedidos");
        }
    }

    @FXML
    void handleProducts(ActionEvent event) {
        if (event.getSource() == btnProducts){
            lbTitle.setText("Produtos");
        }
    }

    @FXML
    void handleUser(ActionEvent event) {
        if (event.getSource() == btnUser){
            lbTitle.setText("Usuários");
        }
    }

    @FXML
    void handleMainClose(ActionEvent event) {
        if (event.getSource() == btnMainClose){
            Platform.exit();
        }
    }

    @FXML
    void initialize(){

    }
}