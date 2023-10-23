import product.Menu;
import product.Product;

public class Kiosk {
    private static int status;
    private static int previousStatus;

    private static Menu[] menu = McMenu.mcMenu.clone();
    private static Product[] products;
    private static OutputDevice display = new OutputDevice();
    private static InputDevice input = new InputDevice();
    private static Order orders = new Order();

    public static boolean start() {
        status = KioskStatus.MAIN_MENU;
        int item = 0;
        while (status > -1) {
            switch (status) {
                case KioskStatus.MANAGER -> {
                    display.displayManagerMode();
                    controllManager();
                }
                case KioskStatus.MAIN_MENU -> {
                    display.displayMainMenu(menu);
                    controllMainMenu();
                }
                case KioskStatus.PRODUCT_MENU -> {
                    display.displayProductMenu(products);
                    item = controllPoroductMenu();
                }
                case KioskStatus.PRODUCT_ADD -> {
                    display.displayAddProduct(products[item]);
                    controllAddProduct(products[item]);
                }
                case KioskStatus.CART -> {
                    display.displayCart(orders);
                    controllCart(orders);
                }
                case KioskStatus.ORDER_CANCEL -> {
                    display.displayCancelOrder();
                    controllCancelOrder();
                }
                case KioskStatus.ORDER_COMPLETE -> {
                    try {
                        display.displayOrderComplete(orders);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        status = KioskStatus.MAIN_MENU;
                        controllOrderComplete();
                        try{
                            input.receiveClean();
                        } catch (Exception ignored){
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void controllManager() {
        int answer = input.receiveInput(1);
        display.displayLine();
        status = KioskStatus.MANAGER;
        if (answer == 1) {
            status = previousStatus;
        }
    }

    // 메인메뉴를 컨트롤 하는 메서드
    public static void controllMainMenu() {
        int answer = input.receiveInput(menu.length + 2);
        display.displayLine();
        status = KioskStatus.PRODUCT_MENU;
        previousStatus = KioskStatus.MAIN_MENU;
        //갯수에따른 리팩토링이 필요할지도
        switch (answer) {
            case -1 -> status = previousStatus;
            case 0 -> status = KioskStatus.MANAGER;
            case 1 -> products = McProduct.buggers;
            case 2 -> products = McProduct.sides;
            case 3 -> products = McProduct.beverages;
            case 4 -> products = McProduct.desserts;
            case 5 -> status = KioskStatus.CART;
            case 6 -> status = KioskStatus.ORDER_CANCEL;
        }
    }

    // 상품메뉴를 컨트롤 하는 메서드
    public static int controllPoroductMenu() {
        int answer = input.receiveInput(products.length);
        display.displayLine();
        previousStatus = KioskStatus.PRODUCT_MENU;
        switch (answer) {
            case -1 -> status = previousStatus;
            case 0 -> status = KioskStatus.MANAGER;
            default -> status = KioskStatus.PRODUCT_ADD;
        }
        return answer - 1; // 인덱스 값으로 넘기기 위해
    }

    // 구매화면 컨트롤 하는 메서드
    public static void controllAddProduct(Product p) {
        int answer = input.receiveInput(2);
        display.displayLine();
        status = KioskStatus.MAIN_MENU;
        previousStatus = KioskStatus.PRODUCT_ADD;
        switch (answer) {
            case -1 -> status = previousStatus;
            case 0 -> status = KioskStatus.MANAGER;
            case 1 -> {
                orders.addProduct(p);
                display.displayProductAdded(p);
            }
        }
    }

    // 장바구니화면을 컨트롤 하는 메서드
    public static void controllCart(Order o) {
        int answer = input.receiveInput(2);
        display.displayLine();
        status = KioskStatus.MAIN_MENU;
        previousStatus = KioskStatus.CART;
        switch (answer) {
            case -1 -> status = previousStatus;
            case 0 -> status = KioskStatus.MANAGER;
            case 1 -> {
                if (o.getOrderSize() == 0) {
                    System.out.println("<!> 장바구니가 비어 있어서 주문할 수 없습니다. 메뉴를 추가해주세요.");
                    System.out.println();
                } else {
                    status = KioskStatus.ORDER_COMPLETE;
                }
            }
        }
    }

    // 주문취소 화면을 컨트롤하는 메서드
    public static void controllCancelOrder() {
        int answer = input.receiveInput(2);
        display.displayLine();
        status = KioskStatus.MAIN_MENU;
        previousStatus = KioskStatus.ORDER_CANCEL;
        switch (answer) {
            case -1 -> status = previousStatus;
            case 0 -> status = KioskStatus.MANAGER;
            case 1 -> {
                orders.orderClear();
                System.out.println("진행하던 주문이 취소되었습니다.");
                System.out.println();
            }
        }
    }

    // 주문완료 화면 컨트롤
    public static void controllOrderComplete() {
        Order.saveTotalProducts(orders.getProducts());
        orders.orderClear();
        orders.upId();
    }
}
