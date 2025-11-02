package net.runelite.client.plugins.bankwatcher;

public class BankItem {

    private final String name;
    private final int gePrice;
    private final int quantity;
    private final int totalPrice;

    public BankItem(String name, int gePrice, int totalPrice, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.gePrice = gePrice;
        this.totalPrice = totalPrice;
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
        return String.format("%s | Price: %,d | Total: %,d | Quantity: %,d" , name, gePrice, totalPrice, quantity);
    }
}
