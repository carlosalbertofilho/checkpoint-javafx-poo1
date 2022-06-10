package ctd.poo.checkpoint.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Products {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField barSearch;

    @FXML
    private Button btnAddItens;

    @FXML
    private StackPane stackMain;

    @FXML
    private TableView<?> tbItens;

    @FXML
    void handleAddItens(ActionEvent event){

    }
}
