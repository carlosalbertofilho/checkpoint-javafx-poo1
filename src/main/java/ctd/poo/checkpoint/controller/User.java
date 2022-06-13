package ctd.poo.checkpoint.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ctd.poo.checkpoint.model.LegalPerson;
import ctd.poo.checkpoint.model.PhysicalPerson;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
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

    private List<PhysicalPerson> physicalUser;
    private ObservableList<PhysicalPerson> observablePhysicalUser;

    private List<LegalPerson> legalUser;
    private ObservableList<LegalPerson> observableLegalUser;



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

    @FXML
    void initialize(){
        bpListUsers.setVisible(true);
        bpEditUser.setVisible(false);


        /**
         * Validações para o campo editNameUser
         */
        editNameUser.textProperty().addListener(event ->{
            validTextField(editNameUser, 30, "^[a-zA-Z]{2,}+(?:\s[a-zA-Z]+)*");
        });

        /**
         * Altera o tipo do Campo editCPForCNPJUser
         * conforme o checkBox escolhido
         */
        ifLegalPerson.setOnAction(event -> {
            if(ifLegalPerson.isSelected()){
                ifPhysicalPerson.setDisable(true);
                editCPForCNPJUser.setPromptText("CNPJ - XX.XXX.XXX/YYYY-ZZ");
            } else {
                ifPhysicalPerson.setDisable(false);
                editCPForCNPJUser.setPromptText("Escolha Pessoa Física ou Jurídica");
            }
        });
        ifPhysicalPerson.setOnAction(event -> {
            if(ifPhysicalPerson.isSelected()){
                ifLegalPerson.setDisable(true);
                editCPForCNPJUser.setPromptText("CPF - XXX.XXX.XXX-ZZ");
            } else{
                ifLegalPerson.setDisable(false);
                editCPForCNPJUser.setPromptText("Escolha Pessoa Física ou Jurídica");
            }
        });
        /**
         * Validações para o campo editCPForCNPJUser
         */
        editCPForCNPJUser.textProperty().addListener(event -> {
            if(ifPhysicalPerson.isSelected()){
                validTextField(editCPForCNPJUser, 14, "^\\d{3}[.]\\d{3}[.]\\d{3}[-]\\d{2}$");
            }
            if(ifLegalPerson.isSelected()){
                validTextField(editCPForCNPJUser, 18, "^\\d{2}\\.\\d{3}\\.\\d{3}[/]\\d{4}[-]\\d{2}$");
            }
        });
        /**
         * Validação para o campo de Endereço do usuário
         */
        editAddressUser.setOnAction(event -> {
            validTextField(editAddressUser, 45, "^[a-zA-Z]{5,}+(?:\s[a-zA-Z]+)*");
        });
        /**
         * Validação para o campo de Telefone do usuário
         */
        editPhoneUser.setOnAction(event -> {
            validTextField(editPhoneUser, 15, "^\\([0-9]{2}\\) [0-9]?[0-9]{4}-[0-9]{4}$");
        });

    }

}
