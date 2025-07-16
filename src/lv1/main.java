package lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    static class MenuItem {
        private String name;
        private double price;
        private String description;

        public MenuItem(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getDescription() {
            return description;
        }

        public String getFormattedString() {
            return String.format("%-15s | W %.1f | %s", name, price, description);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> burgerMenu = new ArrayList<>();

        burgerMenu.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n[ SHAKESHACK MENU ]");
            for (int i = 0; i < burgerMenu.size(); i++) {
                System.out.println((i + 1) + ". " + burgerMenu.get(i).getFormattedString());
            }
            System.out.println("0. 종료");
            System.out.println("--------------------");
            System.out.print("메뉴를 선택해주세요: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= burgerMenu.size()) {
                    MenuItem selectedItem = burgerMenu.get(choice - 1);
                    System.out.println("\n선택하신 메뉴는 '" + selectedItem.getName() + "' 입니다.");
                    System.out.println(selectedItem.getDescription() + "\n");
                } else if (choice == 0) {
                    System.out.println("\n프로그램을 종료합니다.");
                } else {
                    System.out.println("\n유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n잘못된 입력입니다. 숫자를 입력해주세요.\n");
                scanner.close();
                scanner = new Scanner(System.in);
            }
        }
        scanner.close();
    }
}