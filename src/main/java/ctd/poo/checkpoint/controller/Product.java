package ctd.poo.checkpoint.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Product {
    @FXML
    private TextField barSearch;

    @FXML
    private BorderPane bpAddProduct;

    @FXML
    private BorderPane bpListProducts;

    @FXML
    private Button btnAddProducts;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField editAmountProduct;

    @FXML
    private TextArea editDescriptionProduct;

    @FXML
    private TextField editNameProduct;

    @FXML
    private TextField editPriceProduct;

    @FXML
    private Text labelTitle;

    @FXML
    private StackPane stackMain;

    @FXML
    private TableView<?> tbProducts;

    @FXML
    void handleBtnAddProducts(ActionEvent event){
        bpAddProduct.toFront();
        bpAddProduct.setVisible(true);
        bpListProducts.setVisible(false);
        labelTitle.setText("Lista de Produtos > Adicionar Produto");
    }

    @FXML
    void handleBtnCancel(ActionEvent event){
        bpListProducts.toFront();
        bpListProducts.setVisible(true);
        bpAddProduct.setVisible(false);
        labelTitle.setText("Lista de Produtos");
    }

    @FXML
    void initialize(){
        bpListProducts.setVisible(true);
        bpAddProduct.setVisible(false);
    }
}
