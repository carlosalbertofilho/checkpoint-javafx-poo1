package ctd.poo.checkpoint.controller;

import ctd.poo.checkpoint.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ProductsController {
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
    private Label spamBtnSave;

    @FXML
    private TableView<Product> tbProducts;

    @FXML
    private TableColumn<Product, Integer> viewAmount;

    @FXML
    private TableColumn<Product, String> viewDescription;

    @FXML
    private TableColumn<Product, String> viewName;

    @FXML
    private TableColumn<Product, Double> viewPrice;

    private static List<Product> listProduct = new ArrayList<>();
    private ObservableList<Product> observableListProduct;

    private void loadTableView(){
        viewName.setCellValueFactory(new PropertyValueFactory<>("name"));
        viewAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        viewPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        viewDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        observableListProduct = FXCollections.observableArrayList(listProduct);
        tbProducts.setItems(observableListProduct);
    }

    public static List<Product> getListProduct() {
        return listProduct;
    }

    /**
     * Metodo auxiliar valida o campo TextField
     * @param field Campo que será validado
     * @param maxLength tamanho máximo de caracteres do campo
     * @param regex Expressão regular com o formato padrão do campo
     */
    private void validTextField(TextField field, int maxLength, String regex){
        // Limita o input até maxLength caracteres
        if (field.getText().length() > maxLength ){
            String s = field.getText().substring(0, maxLength);
            field.setText(s);
        }
        // aplica os padrões de texto
        field.pseudoClassStateChanged(
                PseudoClass.getPseudoClass("error"),
                !field.getText().isEmpty() &&
                        !field.getText().matches(regex)
        );
    }

    private boolean checkEmptyField(){
        return editNameProduct.getText().isEmpty() &&
                editPriceProduct.getText().isEmpty() &&
                editAmountProduct.getText().isEmpty() &&
                editDescriptionProduct.getText().isEmpty();
    }

    @FXML
    void initialize(){
        bpListProducts.setVisible(true);
        bpAddProduct.setVisible(false);
        loadTableView();

        /**
         * Valida Campo editNameProduct
         */
        editNameProduct.textProperty().addListener(event -> {
            validTextField(editNameProduct, 30, "^[a-zA-z]{2,30}$");
        });

        /**
         * Valida Campo editAmountProduct
         */
        editAmountProduct.textProperty().addListener(event -> {
            validTextField(editAmountProduct, 7, "^[+]?\\d*$");
        });

        /**
         * Valida campo editPriceProduct
         */
        editPriceProduct.textProperty().addListener(event -> {
            validTextField(editPriceProduct, 14, "\\d{1,3}(\\.\\d{3})*,\\d{2}");
        });

        /**
         * Valida campo
         */
        editDescriptionProduct.textProperty().addListener(event -> {
            if (editDescriptionProduct.getText().length() > 250 ){
                String s = editDescriptionProduct.getText().substring(0, 250);
                editDescriptionProduct.setText(s);
            }
        });

        /**
         * Ação do botão btnAddProducts
         */
        btnAddProducts.setOnAction(event -> {
            bpAddProduct.toFront();
            bpAddProduct.setVisible(true);
            bpListProducts.setVisible(false);
            labelTitle.setText("Lista de Produtos > Adicionar Produto");
        });

        /**
         * Ação do botão btnCancel
         */
        btnCancel.setOnAction(event -> {
            bpListProducts.toFront();
            bpListProducts.setVisible(true);
            bpAddProduct.setVisible(false);
            labelTitle.setText("Lista de Produtos");
        });

        /**
         * Ação do botão btnSave
         */
        btnSave.setOnAction(event -> {
            if(checkEmptyField()) spamBtnSave.setVisible(true);
            else {
                spamBtnSave.setVisible(false);
                int idProduct = listProduct.size() + 1;
                Product newProduct = new Product(
                        idProduct,
                        editNameProduct.getText(),
                        Integer.parseInt(editAmountProduct.getText()),
                        Double.parseDouble(editPriceProduct.getText()),
                        editDescriptionProduct.getText());
                listProduct.add(newProduct);
                loadTableView();
                bpListProducts.toFront();
                bpListProducts.setVisible(true);
                bpAddProduct.setVisible(false);
                labelTitle.setText("Lista de Produtos");
            }
        });
    }
}