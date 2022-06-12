package ctd.poo.checkpoint.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class User {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField barSearch;

    @FXML
    private BorderPane bpEditUser;

    @FXML
    private BorderPane bpListUsers;

    @FXML
    private Button btnAddUser;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField editAddressUser;

    @FXML
    private TextField editCPForCNPJUser;

    @FXML
    private TextField editNameUser;

    @FXML
    private TextField editPhoneUser;

    @FXML
    private CheckBox ifLegalPerson;

    @FXML
    private CheckBox ifPhysicalPerson;

    @FXML
    private TableColumn<?, ?> showAddressUser;

    @FXML
    private TableColumn<?, ?> showCPForCNPJUser;

    @FXML
    private TableColumn<?, ?> showIDUser;

    @FXML
    private TableColumn<?, ?> showNameUser;

    @FXML
    private TableColumn<?, ?> showPhoneUser;

    @FXML
    private StackPane stackMain;

    @FXML
    private TableView<?> tbUsers;

    @FXML
    private Text labelTitle;

    @FXML
    void handleBtnAddUser(ActionEvent event) {
        bpEditUser.toFront();
        bpEditUser.setVisible(true);
        bpListUsers.setVisible(false);
        labelTitle.setText("Lista de Usuários > Novo Usuário");
    }

    @FXML
    void handleBtnCancel(ActionEvent event){
        bpListUsers.toFront();
        bpListUsers.setVisible(true);
        bpEditUser.setVisible(false);
        labelTitle.setText("Lista de Usuários");
    }

    @FXML
    void initialize(){
        bpListUsers.setVisible(true);
        bpEditUser.setVisible(false);
    }

}
