package lv4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> mainMenus;
    private Scanner scanner;

    public Kiosk(List<Menu> mainMenus) {
        this.mainMenus = mainMenus;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int mainMenuChoice = -1;

        while (mainMenuChoice != 0) {
            displayMainMenus(); // 메인 메뉴 (카테고리) 출력
            System.out.print("메뉴를 선택해주세요: ");

            try {
                mainMenuChoice = scanner.nextInt();
                scanner.nextLine();

                if (mainMenuChoice >= 1 && mainMenuChoice <= mainMenus.size()) {
                    Menu selectedMenu = mainMenus.get(mainMenuChoice - 1);
                    processSubMenu(selectedMenu); // 서브 메뉴 (MenuItem) 처리
                } else if (mainMenuChoice == 0) {
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
        System.out.println("--------------------");
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
}