package ctd.poo.checkpoint.controller;

import ctd.poo.checkpoint.model.PhysicalPerson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.List;

public class InvoicesController {

    @FXML
    private TextField amountInvoice;

    @FXML
    private TextField amountProduct;

    @FXML
    private TextField barSearch;

    @FXML
    private Pane bpEditProduct;

    @FXML
    private BorderPane bpListInvoices;

    @FXML
    private Button btnAddInvoice;

    @FXML
    private Button btnAddProduct;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> choiceProduct;

    @FXML
    private ComboBox<PhysicalPerson> choiceUser;

    @FXML
    private RadioButton ifLegalPerson;

    @FXML
    private RadioButton ifPhysicalPerson;

    @FXML
    private Text mainTitle;

    @FXML
    private TextField quantityStock;

    @FXML
    private ChoiceBox<?> selectClient;

    @FXML
    private StackPane stackMain;

    @FXML
    private TableView<?> tbInvoice;

    @FXML
    private TableColumn<?, ?> viewAmountProduct;

    @FXML
    private TableColumn<?, ?> viewClient;

    @FXML
    private TableColumn<?, ?> viewCreatedAt;

    @FXML
    private TableColumn<?, ?> viewDeliveryAddress;

    @FXML
    private TableColumn<?, ?> viewID;

    @FXML
    private TableColumn<?, ?> viewNameProduct;

    @FXML
    private TableColumn<?, ?> viewPriceProduct;

    @FXML
    private TableView<?> viewProduct;

    @FXML
    private TableColumn<?, ?> viewValueOrder;

    /**
     * Função auxiliar que carregar a lista de usuários
     * Pessoa Física
     */
    private void loadPhysicalPerson(){
        final List<PhysicalPerson> physicalUser = UserController.getPhysicalUser();
        ObservableList<PhysicalPerson> physicalPersonObservableList;
        physicalPersonObservableList = FXCollections.observableArrayList(physicalUser);
        choiceUser = new ComboBox<PhysicalPerson>();
        choiceUser.setItems(physicalPersonObservableList);
    }

    @FXML
    void initialize(){
        bpListInvoices.setVisible(true);
        bpEditProduct.setVisible(false);


        btnAddInvoice.setOnAction(event -> {
            bpListInvoices.setVisible(false);
            bpEditProduct.setVisible(true);
            mainTitle.setText("Gerência de Pedidos > Adicionar Pedido");
        });

        btnCancel.setOnAction(event -> {
            bpListInvoices.setVisible(true);
            bpEditProduct.setVisible(false);
            mainTitle.setText("Gerência de Pedidos");
        });

        ifPhysicalPerson.setOnAction(event -> {
            if(ifPhysicalPerson.isSelected()){
                ifLegalPerson.setDisable(true);
                loadPhysicalPerson();
            } else ifLegalPerson.setDisable(false);
        });

        ifLegalPerson.setOnAction(event -> {
            if(ifLegalPerson.isSelected()){
                ifPhysicalPerson.setDisable(true);
            } else ifPhysicalPerson.setDisable(false);
        });


    }
}
