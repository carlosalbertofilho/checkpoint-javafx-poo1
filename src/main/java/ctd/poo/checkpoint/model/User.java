package ctd.poo.checkpoint.model;

public abstract class User {
    private int id;
    private String name;
    private String phone;
    private String street;
    private String postalCod;
    private String numberStreet;

    /**
     * Contrutor da Classe Cliente
     * @param id id do Cliente
     * @param name Nome do Cliente
     * @param phone Telefone do Cliente
     * @param street Logradouro do Cliente
     * @param postalCod CEP do Cliente
     * @param numberStreet Número do logadouro do Cliente
     */
    public User(int id,
                String name,
                String phone,
                String street,
                String postalCod,
                String numberStreet) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setStreet(street);
        this.setPostalCod(postalCod);
        this.setNumberStreet(numberStreet);
    }

    /**
     * Metódo formata o endereço do cliente
     * @return Endereço do Cliente
     */
    public String getAddress(){
        return "%s , Nº: %s , CEP: %s".formatted(
                            getStreet(),
                            getNumberStreet(),
                            getPostalCod());
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCod() {
        return postalCod;
    }

    public void setPostalCod(String postalCod) {
        this.postalCod = postalCod;
    }

    public String getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(String numberStreet) {
        this.numberStreet = numberStreet;
    }
}
