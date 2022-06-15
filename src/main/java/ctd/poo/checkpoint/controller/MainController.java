package ctd.poo.checkpoint.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text lbTitle;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane defaultPane;

    @FXML
    private BorderPane mainBorderPane;

    private void handleGeneric(String mainTitle, String view){
        lbTitle.setText(mainTitle);
        try {
            mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource((view))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(mainPane);
    }

    @FXML
    void handleDashboard(ActionEvent event) throws IOException {
        mainBorderPane.setCenter(defaultPane);
    }

    @FXML
    void handleAuthor(ActionEvent event) {
        handleGeneric("Créditos", "author.fxml");
    }

    @FXML
    void handleInvoice(ActionEvent event) {
        handleGeneric("Pedidos", "invoice.fxml");
    }

    @FXML
    void handleProducts(ActionEvent event) {
        handleGeneric("Produtos", "products.fxml");
    }

    @FXML
    void handleUser(ActionEvent event) {
        handleGeneric("Usuários", "user.fxml");
    }

    @FXML
    void handleMainClose(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize(){
        defaultPane.toFront();
    }
}