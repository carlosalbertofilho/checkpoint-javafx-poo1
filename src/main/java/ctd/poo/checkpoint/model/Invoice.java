package ctd.poo.checkpoint.model;

import javafx.util.Pair;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
    private int id;
    private LocalDate createdAt;
    private PhysicalPerson physicalUser;
    private LegalPerson legalUser;
    private List<Pair<Product, Integer>> items;

    /**
     * Contrutor da Classe Invoice
     * @param id ID do Pedido
     * @param createdAt Data e Hora em que o pedido foi criado
     * @param physicalUser Se o cliente que fez o pedido é pessoa Física
     * @param items Lista contento o Produto pedido e quantidade do mesmo
     */
    public Invoice(int id, LocalDate createdAt, PhysicalPerson physicalUser, List<Pair<Product, Integer>> items) {
        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setPhysicalUser(physicalUser);
        this.setItems(items);
        this.setLegalUser(null);
    }
    /**
     * Contrutor da Classe Invoice
     * @param id ID do Pedido
     * @param createdAt Data e Hora em que o pedido foi criado
     * @param legalUser Se o cliente que fez o pedido é pessoa Jurídica
     * @param items Lista contento o Produto pedido e quantidade do mesmo
     */
    public Invoice(int id, LocalDate createdAt,  LegalPerson legalUser, List<Pair<Product, Integer>> items) {
        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setLegalUser(legalUser);
        this.setItems(items);
        this.setPhysicalUser(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public PhysicalPerson getPhysicalUser() {
        return physicalUser;
    }

    public void setPhysicalUser(PhysicalPerson physicalUser) {
        this.physicalUser = physicalUser;
    }

    public LegalPerson getLegalUser() {
        return legalUser;
    }

    public void setLegalUser(LegalPerson legalUser) {
        this.legalUser = legalUser;
    }

    public List<Pair<Product, Integer>> getItems() {
        return items;
    }

    public void setItems(List<Pair<Product, Integer>> items) {
        this.items = items;
    }
}
