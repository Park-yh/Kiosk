package Challenge_lv1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<CartItem> cartItems;

    public Order() {
        this.cartItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        // 이미 장바구니에 있는 메뉴인지 확인 (선택 사항: Lv1 도전과제 핵심은 아니지만 좋은 연습)
        for (CartItem cartItem : cartItems) {
            if (cartItem.getItem().getName().equals(item.getName())) {
                cartItem.setQuantity(cartItem.getQuantity() + 1); // 수량 증가
                System.out.println(item.getName() + " 메뉴의 수량이 1 증가했습니다. (현재: " + cartItem.getQuantity() + "개)");
                return;
            }
        }
        // 새로운 메뉴라면 추가
        cartItems.add(new CartItem(item));
        System.out.println(item.getName() + " 이(가) 장바구니에 추가되었습니다.");
    }

    public double getTotalOrderPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("\n[ Orders ]");
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        for (CartItem cartItem : cartItems) {
            // Lv1 출력 예시에 맞게 MenuItem의 description을 그대로 사용하거나,
            // CartItem의 formatted string을 사용해도 됩니다. (저는 CartItem의 formatted string 사용)
            System.out.println(cartItem.getFormattedString());
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f\n", getTotalOrderPrice());
    }

    public void clearOrder() {
        cartItems.clear();
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
