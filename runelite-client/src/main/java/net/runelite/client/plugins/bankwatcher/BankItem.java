package net.runelite.client.plugins.bankwatcher;

public class BankItem {

    private int id;
    private final String name;
    private final int gePrice;
    private final int quantity;
    private final int totalPrice;
    private final int delta;

    public BankItem(int id, String name, int gePrice, int totalPrice, int quantity, int delta) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.gePrice = gePrice;
        this.totalPrice = totalPrice;
        this.delta = delta;

    }

    public int getId() {
        return id;
    }
    public int getDelta(){
        return delta;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public int getGePrice() {
        return gePrice;
    }
    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString(){
        return String.format(
                "%s | Price: %,d | Total: %,d | Quantity: %,d | Delta: %,d",
                name, gePrice, totalPrice, quantity, delta
        );
    }
}
