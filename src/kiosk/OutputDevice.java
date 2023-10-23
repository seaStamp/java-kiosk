package kiosk;

import model.Menu;
import model.Order;
import model.Product;
import product.Bugger;

public class OutputDevice {

    public void displayLine() {
        System.out.println("-----------------------------------------------------------------");
    }

    public void welcomeMessage() {
        System.out.println("\"McDonalds에 오신걸 환영합니다.\"");
    }

    // 메인 메뉴화면 출력
    public void displayMainMenu(Menu[] m) {
        welcomeMessage();
        int i = 0;
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ McDonalds MENU ]");
        for (; i < m.length; i++) {
            System.out.printf("%d. %-20s | %s\n", i + 1, m[i].getMenuName(), m[i].getMenuInfo());
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.printf("%d. %-10s| %s\n", ++i, "Order", "장바구니를 확인 후 주문합니다");
        System.out.printf("%d. %-10s| %s\n", ++i, "Cancel", "진행중인 주문을 취소합니다");
        displayLine();
        System.out.print("> ");
    }

    // 상품화면을 출력
    public void displayProductMenu(Product[] p) {
        welcomeMessage();
        System.out.println("아래 상품메뉴판을 보시고 상품 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ " + p[0].getMenuName() + " MENU ]");
        for (int i = 0; i < p.length; i++) {
            System.out.printf("%d. %-22s | W %.1f | %s\n", i + 1, p[i].getProductName(), p[i].getPrice(),
                    p[i].getMenuInfo());
        }
        displayLine();
        System.out.print("> ");
    }


    // 구매화면 출력
    public void displayAddProduct(Product p) {
        System.out.printf("\"%-22s | W %.1f | %s\"\n", p.getProductName(), p.getPrice(), p.getMenuInfo());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t2. 취소");
        displayLine();
        System.out.print("> ");
    }

    public void displayProductAdded(Product p) {
        System.out.printf("%s가 장바구니에 추가되었습니다\n\n", p.getProductName());
    }

    // 장바구니 화면 출력
    public void displayCart(Order o) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        for (Product p : o.getProducts()) {
            System.out.printf("%-22s| W %.1f | %d개 | %s\n", p.getProductName(), p.getPrice(), p.getQuantity(),
                    p.getMenuInfo());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("W %.1f\n\n", o.getTotalCost());
        System.out.println("1. 주문\t\t2. 메뉴판");
        displayLine();
        System.out.print("> ");
    }

    // 주문취소화면 출력
    public void displayCancelOrder() {

        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인\t\t2. 취소");
        displayLine();
        System.out.print("> ");
    }

    // 주문완료 화면
    public void displayOrderComplete(Order o) throws InterruptedException {
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.printf("대기번호는 [ %d ] 번 입니다.\n", o.getId());
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        Thread.sleep(3000);
        displayLine();
    }

    // 관리자모드 화면
    public void displayManagerMode() {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n\n", Order.getTotalProductsCost());
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();
        for (Product p : Order.getTotalProducts()) {
            System.out.printf("%-22s| W %.1f\n", p.getProductName(), p.getPrice() * p.getTotalQuantity());
        }
        System.out.println();
        System.out.println("1. 돌아가기");
        displayLine();
        System.out.print("> ");
    }

    public void displayProductOption(Product p) {
        System.out.printf("\"%-22s | W %.1f | %s\"\n", p.getProductName(), p.getPrice(), p.getMenuInfo());
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        System.out.printf("1. %s(W %.1f) \t\t2. %s(W %.1f)\n", p.getOption(), p.getPrice(), p.pOption.getOption(),
                p.pOption.getPrice());
        displayLine();
        System.out.print("> ");
    }
}
