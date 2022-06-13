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
    private AnchorPane mainPane;

    @FXML
    private BorderPane mainBorderPane;


    @FXML
    void handleDashboard(ActionEvent event) throws IOException {
        lbTitle.setText("Dashboard");
        try {
            mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("dashboard.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(mainPane);
    }

    @FXML
    void handleAuthor(ActionEvent event) {
        lbTitle.setText("Créditos");
        try {
            mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("author.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(mainPane);

    }

    @FXML
    void handleInvoice(ActionEvent event) {
        lbTitle.setText("Pedidos");
        try {
            mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("invoice.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(mainPane);
    }

    @FXML
    void handleProducts(ActionEvent event) {
        lbTitle.setText("Produtos");
        try {
            mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("products.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(mainPane);
    }

    @FXML
    void handleUser(ActionEvent event) {
        lbTitle.setText("Usuários");
        try {
            mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("user.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(mainPane);
    }

    @FXML
    void handleMainClose(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize(){

    }
}