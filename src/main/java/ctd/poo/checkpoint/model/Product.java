package ctd.poo.checkpoint.model;

import javafx.util.Pair;

public class Product {
    private int id;
    private String name;
    private Integer amount;
    private Double price;
    private String description;

    /**
     * Contrutor da Classe Product
     * @param name nome do Produto
     * @param amount quantidade do produto em estoque
     * @param price preço do produto
     * @param description descrição do produto
     */
    public Product(int id,
                   String name,
                   Integer amount,
                   Double price,
                   String description) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.description = description;
    }

    /**
     * Reduz a quantidade em estoque
     * @param amount a quantidade que se quer reduzir do produto
     * @return  uma Lista com o objeto do produto e a quantidade solicitada
     */
    public Pair<Product, Integer> debitProduct(Integer amount){
        if (amount < getAmount())
            setAmount(getAmount() - amount);
        return new Pair<>(this, amount);
    }

    /**
     * Calcula o preço de determinada quantidade de um produto
     * @param amount a quantidade que se quer calcular
     * @return o preço unitário do produto vezes a quantidade
     */
    public double getAmountPrice(Integer amount){
        return amount * getPrice();
    }

    @Override
    public String toString() {
        return getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
