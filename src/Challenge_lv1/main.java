package Challenge_lv1;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Menu 객체들을 생성하고 MenuItem들 추가
        Menu burgersMenu = new Menu("Burgers");
        burgersMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgersMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgersMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgersMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItem(new MenuItem("Cola", 1.5, "코카콜라"));
        drinksMenu.addMenuItem(new MenuItem("Sprite", 1.5, "사이다"));
        drinksMenu.addMenuItem(new MenuItem("Zere Cola", 1.5, "제로콜라"));
        drinksMenu.addMenuItem(new MenuItem("Fanta Orange", 1.5, "환타 오랜지맛"));
        drinksMenu.addMenuItem(new MenuItem("Fanta Grape", 1.5, "환타 포도맛"));

        Menu dessertsMenu = new Menu("Desserts");
        dessertsMenu.addMenuItem(new MenuItem("Cheese Stick", 2.3, "치즈스틱"));
        dessertsMenu.addMenuItem(new MenuItem("Vanilla Shake", 3.0, "바닐라 쉐이크"));
        dessertsMenu.addMenuItem(new MenuItem("French Fries", 2.0, "감자튀김"));
        dessertsMenu.addMenuItem(new MenuItem("Chicken Nuggets", 2.5, "치킨너겟"));

        // 메인 메뉴 리스트를 생성하여 Menu 객체들을 담음
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(burgersMenu);
        mainMenus.add(drinksMenu);
        mainMenus.add(dessertsMenu);

        // Kiosk 객체를 생성하고 메인 메뉴 리스트를 전달
        Kiosk kiosk = new Kiosk(mainMenus);
        // Kiosk의 start 메소드를 호출하여 프로그램 흐름을 시작
        kiosk.start();
    }
}