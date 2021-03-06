package ctd.poo.checkpoint.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ctd.poo.checkpoint.model.LegalPerson;
import ctd.poo.checkpoint.model.PhysicalPerson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class UserController {
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
    private TableColumn<PhysicalPerson, String> showAddressUser;

    @FXML
    private TableColumn<PhysicalPerson, String> showCPForCNPJUser;

    @FXML
    private TableColumn<PhysicalPerson, String> showNameUser;

    @FXML
    private TableColumn<PhysicalPerson, String> showPhoneUser;

    @FXML
    private TextField editNumberStreet;

    @FXML
    private TextField editPostalCod;

    @FXML
    private StackPane stackMain;

    @FXML
    private TableView<PhysicalPerson> tbUsers = new TableView<PhysicalPerson>();

    @FXML
    private Text labelTitle;

    @FXML
    private Label spamBtnSave;

    private static final List<PhysicalPerson> physicalUser = new ArrayList<>();
    private ObservableList<PhysicalPerson> observablePhysicalUser;

    private static List<LegalPerson> legalUser = new ArrayList<>();
    private ObservableList<LegalPerson> observableLegalUser;

    public static List<PhysicalPerson> getPhysicalUser() {
        return physicalUser;
    }
    public static List<LegalPerson> getLegalUser() {
        return legalUser;
    }

    /**
     * Dados de Teste
     */
    private void loadUserTest(){
        if(physicalUser.size() == 0){
            PhysicalPerson user1 = new PhysicalPerson(1,
                    "Carlos Filho",
                    "123.123.123-09",
                    "(21) 12345-0982",
                    "Rua 01",
                    "12345-098",
                    "10");
            physicalUser.add(user1);
            PhysicalPerson user2 = new PhysicalPerson(2,
                    "Tchotchoza",
                    "234.234.234-98",
                    "(21) 12345-1234",
                    "Rua 02",
                    "23456-789",
                    "15");
            physicalUser.add(user2);
        }
        if(legalUser.size() == 0){
            LegalPerson user3 = new LegalPerson(1,
                    "XPTO",
                    "12.123.123/0001-01",
                    "(21) 12345-0987",
                    "Rua 10",
                    "54321-098",
                    "25");
            legalUser.add(user3);
            LegalPerson user4 = new LegalPerson(1,
                    "Contoso",
                    "32.123.123/0001-01",
                    "(21) 34567-0987",
                    "Rua 30",
                    "76543-098",
                    "55");
            legalUser.add(user4);
        }
    }
    /**
     * Carregar dados do usu??rio Pessoa F??sica para a tabela
     */
    private void  loadTableView(){
        showNameUser.setCellValueFactory(new PropertyValueFactory<>("name"));
        showPhoneUser.setCellValueFactory(new PropertyValueFactory<>("phone"));
        showAddressUser.setCellValueFactory(new PropertyValueFactory<>("street"));
        showCPForCNPJUser.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        observablePhysicalUser = FXCollections.observableArrayList(physicalUser);
        tbUsers.setItems(observablePhysicalUser);
    }

    /**
     * Metodo auxiliar valida o campo TextField
     * @param field Campo que ser?? validado
     * @param maxLength tamanho m??ximo de caracteres do campo
     * @param regex Express??o regular com o formato padr??o do campo
     */
    private void validTextField(TextField field, int maxLength, String regex){
        // Limita o input at?? maxLength caracteres
        if (field.getText().length() > maxLength ){
            String s = field.getText().substring(0, maxLength);
            field.setText(s);
        }
        // aplica os padr??es de texto
        field.pseudoClassStateChanged(
                PseudoClass.getPseudoClass("error"),
                !field.getText().isEmpty() &&
                        !field.getText().matches(regex)
        );
    }

    private boolean checkEmptyField(){
        return editNameUser.getText().isEmpty() &&
               editCPForCNPJUser.getText().isEmpty() &&
               editAddressUser.getText().isEmpty() &&
               editPhoneUser.getText().isEmpty() &&
               editNumberStreet.getText().isEmpty() &&
               editPostalCod.getText().isEmpty();
    }

    private void clearFields(){
        editNameUser.setText("");
        editCPForCNPJUser.setText("");
        editAddressUser.setText("");
        editPhoneUser.setText("");
        editNumberStreet.setText("");
        editPostalCod.setText("");
        ifPhysicalPerson.setSelected(false);
        ifLegalPerson.setSelected(false);
    }

    @FXML
    void initialize(){
        bpListUsers.setVisible(true);
        bpEditUser.setVisible(false);
        loadUserTest();
        loadTableView();

        /**
         * Implementa a????o para o bot??o btnAddUser
         */
        btnAddUser.setOnAction(event -> {
            bpEditUser.toFront();
            bpEditUser.setVisible(true);
            bpListUsers.setVisible(false);
            labelTitle.setText("Lista de Usu??rios > Novo Usu??rio");
        });

        /**
         * Implementa a????o para o bot??o btnCancel
         */
        btnCancel.setOnAction(event -> {
            bpListUsers.toFront();
            bpListUsers.setVisible(true);
            bpEditUser.setVisible(false);
            labelTitle.setText("Lista de Usu??rios");
        });

        /**
         * Valida????es para o campo editNameUser
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
                editCPForCNPJUser.setPromptText("Escolha Pessoa F??sica ou Jur??dica");
            }
        });
        ifPhysicalPerson.setOnAction(event -> {
            if(ifPhysicalPerson.isSelected()){
                ifLegalPerson.setDisable(true);
                editCPForCNPJUser.setPromptText("CPF - XXX.XXX.XXX-ZZ");
            } else{
                ifLegalPerson.setDisable(false);
                editCPForCNPJUser.setPromptText("Escolha Pessoa F??sica ou Jur??dica");
            }
        });
        /**
         * Valida????es para o campo editCPForCNPJUser
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
         * Valida????o para o campo de Endere??o do usu??rio
         */
        editAddressUser.setOnAction(event -> {
            validTextField(editAddressUser, 45, "^[a-zA-Z]{5,}+(?:\s[a-zA-Z]+)*");
        });

        /**
         * Valida????o para o Campo Cep do Endere??o do usu??rio
         */
        editPostalCod.setOnAction(event -> {
            validTextField(editPostalCod, 9, "^\\d{5}[-]\\d{3}$");
        });

        editNumberStreet.setOnAction(event -> {
            validTextField(editNumberStreet, 5, "^\\d{1,5}$");
        });

        /**
         * Valida????o para o campo de Telefone do usu??rio
         */
        editPhoneUser.setOnAction(event -> {
            validTextField(editPhoneUser, 15, "^[(]\\d{2}[)] \\d{4,5}[-]\\d{4}$");
        });

        btnSave.setOnAction(event -> {
            if(checkEmptyField()) spamBtnSave.setVisible(true);
            else {
                spamBtnSave.setVisible(false);
                if(ifPhysicalPerson.isSelected() && !checkEmptyField()){
                    int idPhysicalPerson = physicalUser.size() + 1;
                    PhysicalPerson newUser = new PhysicalPerson( idPhysicalPerson,
                            editNameUser.getText(),
                            editCPForCNPJUser.getText(),
                            editPhoneUser.getText(),
                            editAddressUser.getText(),
                            editPostalCod.getText(),
                            editNumberStreet.getText());
                    physicalUser.add(newUser);
                    loadTableView();
                }
                if(ifLegalPerson.isSelected() && !checkEmptyField()){
                    int idLegalPerson = legalUser.size() + 1;
                    LegalPerson newUser = new LegalPerson( idLegalPerson,
                            editNameUser.getText(),
                            editCPForCNPJUser.getText(),
                            editPhoneUser.getText(),
                            editAddressUser.getText(),
                            editPostalCod.getText(),
                            editNumberStreet.getText());
                    legalUser.add(newUser);
                }
                clearFields();
                bpListUsers.toFront();
                bpListUsers.setVisible(true);
                bpEditUser.setVisible(false);
                labelTitle.setText("Lista de Usu??rios");
            }
        });


    }

}
