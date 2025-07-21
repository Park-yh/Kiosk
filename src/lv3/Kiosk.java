package lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;
    private Scanner scanner;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.scanner = new Scanner(System.in); // Scanner를 Kiosk 클래스에서 관리
    }

    public void start() {
        int choice = -1;

        while (choice != 0) {
            displayMenu();
            System.out.print("메뉴를 선택해주세요: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                processChoice(choice);

            } catch (java.util.InputMismatchException e) {
                System.out.println("\n잘못된 입력입니다. 숫자를 입력해주세요.\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getFormattedString());
        }
        System.out.println("0. 종료");
        System.out.println("--------------------");
    }

    private void processChoice(int choice) {
        if (choice >= 1 && choice <= menuItems.size()) {
            MenuItem selectedItem = menuItems.get(choice - 1);
            System.out.println("\n선택하신 메뉴는 '" + selectedItem.getName() + "' 입니다.");
            System.out.println(selectedItem.getDescription() + "\n");
        } else if (choice == 0) {
            System.out.println("\n프로그램을 종료합니다.");
        } else {
            System.out.println("\n유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.\n");
        }
    }
}