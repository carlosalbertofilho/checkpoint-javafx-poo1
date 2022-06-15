package ctd.poo.checkpoint.controller;

import ctd.poo.checkpoint.model.Invoice;
import ctd.poo.checkpoint.model.LegalPerson;
import ctd.poo.checkpoint.model.PhysicalPerson;
import ctd.poo.checkpoint.model.Product;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Pair;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private StackPane stackMain;

    @FXML
    private TableView<Invoice> tbInvoice;

    @FXML
    private TableColumn<Invoice, Double> viewAmountProduct;

    @FXML
    private TableColumn<Invoice, String> viewClient;

    @FXML
    private TableColumn<Invoice, String> viewCreatedAt;

    @FXML
    private TableColumn<Invoice, String> viewDeliveryAddress;

    @FXML
    private TableColumn<Invoice, Integer> viewID;

    @FXML
    private TableColumn<?, ?> viewNameProduct;

    @FXML
    private TableColumn<?, ?> viewPriceProduct;

    @FXML
    private TableView<?> viewProduct;

    @FXML
    private TableColumn<Invoice, String> viewValueOrder;


    /**
     * Carrega as informações dos usuários e dos produtos
     */
    private static final List<PhysicalPerson> physicalUser = UserController.getPhysicalUser();
    private static List<LegalPerson> legalUser = UserController.getLegalUser();
    private static List<Product> listProduct = ProductsController.getListProduct();
    private static List<Invoice> invoiceList = new ArrayList<>();
    private ObservableList<Invoice> invoiceObservableList;

    /**
     * Instância a Class Invoice afim de teste.
     */
    private void loadDataTeste(){

        if (invoiceList.size() == 0) {
            List<Pair<Product, Integer>> items = new ArrayList<>();
            items.add(listProduct.get(0).debitProduct(2));
            items.add(listProduct.get(1).debitProduct(2));
            invoiceList.add(new Invoice(1, LocalDate.now(),
                    physicalUser.get(0), items));
            items.clear();

            items.add(listProduct.get(0).debitProduct(2));
            items.add(listProduct.get(1).debitProduct(2));
            invoiceList.add(new Invoice(2, LocalDate.now(),
                    physicalUser.get(1), items));
            items.clear();

            items.add(listProduct.get(0).debitProduct(10));
            items.add(listProduct.get(1).debitProduct(10));
            invoiceList.add(new Invoice(3, LocalDate.now(),
                    legalUser.get(0), items));
            items.clear();

            items.add(listProduct.get(0).debitProduct(10));
            items.add(listProduct.get(1).debitProduct(10));
            invoiceList.add(new Invoice(4, LocalDate.now(),
                    legalUser.get(1), items));
            items.clear();
        }
    }

    /**
     * Carrega os pedidos na Tabela tbInvoice
     */
    private void loadTableView(){
        viewID.setCellValueFactory(new PropertyValueFactory<>("id"));
        viewClient.setCellValueFactory(item -> {
            return new ReadOnlyStringWrapper(item.getValue().getClient());
        });
        viewDeliveryAddress.setCellValueFactory(item -> {
            return new ReadOnlyStringWrapper(item.getValue().getDeliveryAddress());
        });
        viewCreatedAt.setCellValueFactory(item -> {
            return new ReadOnlyStringWrapper(item.getValue().getCreateAtFormatted());
        });
        viewValueOrder.setCellValueFactory(item -> {
            return new ReadOnlyStringWrapper(item.getValue().getAmountPriceInvoice());
        });

        invoiceObservableList = FXCollections.observableArrayList(invoiceList);
        tbInvoice.setItems(invoiceObservableList);
    }

    /**
     * Função auxiliar que carregar a lista de usuários
     * Pessoa Física
     */
    private void loadPhysicalPerson(){
        ObservableList<PhysicalPerson> physicalPersonObservableList;
        physicalPersonObservableList = FXCollections.observableArrayList(physicalUser);
        choiceUser = new ComboBox<PhysicalPerson>();
        choiceUser.setItems(physicalPersonObservableList);
    }

    @FXML
    void initialize(){
        bpListInvoices.setVisible(true);
        bpEditProduct.setVisible(false);

        loadDataTeste();
        loadTableView();

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
