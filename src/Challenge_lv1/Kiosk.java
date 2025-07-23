package Challenge_lv1;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> mainMenus;
    private Scanner scanner;
    private Order order; // Order 객체 추가

    public Kiosk(List<Menu> mainMenus) {
        this.mainMenus = mainMenus;
        this.scanner = new Scanner(System.in);
        this.order = new Order(); // Order 객체 초기화
    }

    public void start() {
        int mainMenuChoice = -1;

        while (mainMenuChoice != 0) {
            displayMainMenus(); // 메인 메뉴 (카테고리) 출력

            // 장바구니에 상품이 있을 경우에만 ORDER MENU 출력
            if (!order.isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders        | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel        | 진행중인 주문을 취소합니다.");
            }
            System.out.println("--------------------");
            System.out.print("메뉴를 선택해주세요: ");

            try {
                mainMenuChoice = scanner.nextInt();
                scanner.nextLine();

                if (mainMenuChoice >= 1 && mainMenuChoice <= mainMenus.size()) {
                    Menu selectedMenu = mainMenus.get(mainMenuChoice - 1);
                    processSubMenu(selectedMenu); // 서브 메뉴 (MenuItem) 처리
                } else if (mainMenuChoice == 4) { // Orders
                    if (!order.isEmpty()) {
                        processOrderMenu();
                    } else {
                        System.out.println("\n장바구니가 비어있습니다. 주문할 항목이 없습니다.\n");
                    }
                } else if (mainMenuChoice == 5) { // Cancel
                    if (!order.isEmpty()) {
                        processCancelOrder();
                    } else {
                        System.out.println("\n장바구니가 비어있습니다. 취소할 주문이 없습니다.\n");
                    }
                }
                else if (mainMenuChoice == 0) {
                    System.out.println("\n프로그램을 종료합니다.");
                } else {
                    System.out.println("\n유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n잘못된 입력입니다. 숫자를 입력해주세요.\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void displayMainMenus() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < mainMenus.size(); i++) {
            System.out.println((i + 1) + ". " + mainMenus.get(i).getName());
        }
        System.out.println("0. 종료");
    }

    private void processSubMenu(Menu menu) {
        int subMenuChoice = -1;

        while (subMenuChoice != 0) {
            menu.displayMenuItems(); // 해당 카테고리의 MenuItem 출력
            System.out.println("--------------------");
            System.out.print("메뉴를 선택해주세요: ");

            try {
                subMenuChoice = scanner.nextInt();
                scanner.nextLine();

                if (subMenuChoice >= 1 && subMenuChoice <= menu.getMenuItems().size()) {
                    MenuItem selectedItem = menu.getMenuItems().get(subMenuChoice - 1);
                    System.out.println("\n선택한 메뉴: " + selectedItem.getFormattedString());
                    confirmAddToCart(selectedItem); // 장바구니 추가 확인
                } else if (subMenuChoice == 0) {
                    System.out.println("\n메인 메뉴로 돌아갑니다.");
                } else {
                    System.out.println("\n유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n잘못된 입력입니다. 숫자를 입력해주세요.\n");
                scanner.nextLine();
            }
        }
    }

    private void confirmAddToCart(MenuItem item) {
        System.out.println("\n\"" + item.getName() + " | W " + item.getPrice() + " | " + item.getDescription() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        System.out.print("선택: ");

        try {
            int confirmChoice = scanner.nextInt();
            scanner.nextLine();

            if (confirmChoice == 1) {
                order.addMenuItem(item); // Order 객체에 메뉴 추가
            } else if (confirmChoice == 2) {
                System.out.println("장바구니 추가가 취소되었습니다.");
            } else {
                System.out.println("잘못된 선택입니다. 장바구니 추가가 취소됩니다.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 장바구니 추가가 취소됩니다.");
            scanner.nextLine();
        }
    }

    private void processOrderMenu() {
        order.displayOrder(); // 장바구니 내용 출력

        System.out.println("\n1. 주문         2. 메뉴판");
        System.out.print("선택: ");

        try {
            int orderChoice = scanner.nextInt();
            scanner.nextLine();

            if (orderChoice == 1) {
                double total = order.getTotalOrderPrice();
                order.clearOrder(); // 장바구니 비우기
                System.out.printf("\n주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", total);
            } else if (orderChoice == 2) {
                System.out.println("\n메뉴판으로 돌아갑니다.");
            } else {
                System.out.println("\n잘못된 선택입니다. 메뉴판으로 돌아갑니다.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("\n잘못된 입력입니다. 메뉴판으로 돌아갑니다.");
            scanner.nextLine();
        }
    }

    private void processCancelOrder() {
        System.out.println("\n진행중인 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        System.out.print("선택: ");

        try {
            int cancelChoice = scanner.nextInt();
            scanner.nextLine();

            if (cancelChoice == 1) {
                order.clearOrder();
                System.out.println("주문이 취소되었습니다.");
            } else if (cancelChoice == 2) {
                System.out.println("주문 취소를 취소합니다. 메뉴판으로 돌아갑니다.");
            } else {
                System.out.println("잘못된 선택입니다. 주문 취소가 취소됩니다.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 주문 취소가 취소됩니다.");
            scanner.nextLine();
        }
    }
}