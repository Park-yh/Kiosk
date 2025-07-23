package Challenge_lv1;

public class CartItem {
    private MenuItem item;
    private int quantity;

    public CartItem(MenuItem item) {
        this.item = item;
        this.quantity = 1; // 기본 수량은 1
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    public String getFormattedString() {
        return String.format("%-15s | W %.1f | %d개 | W %.1f",
                item.getName(), item.getPrice(), quantity, getTotalPrice());
    }
}