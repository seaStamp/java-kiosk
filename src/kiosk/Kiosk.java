package kiosk;

import model.Menu;
import model.Order;
import model.Product;
import product.McMenu;
import product.McProduct;

public class Kiosk {
    private static int status;
    private static int previousStatus;

    private final static Menu[] menu = McMenu.mcMenu.clone();
    private static Product[] products;
    private final static OutputDevice display = new OutputDevice();
    private final static InputDevice input = new InputDevice();
    private final static Order orders = new Order();

    public static void start() {
        status = KioskStatus.MAIN_MENU;
        Product select = null;
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
                    select = controllPoroductMenu();
                }
                case KioskStatus.PRODUCT_OPTION -> {
                    display.displayProductOption(select);
                    select = controllProductOption(select);
                }
                case KioskStatus.PRODUCT_ADD -> {
                    display.displayAddProduct(select);
                    controllAddProduct(select);
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
                        try {
                            input.receiveClean();
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        }
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
    public static Product controllPoroductMenu() {
        int answer = input.receiveInput(products.length);
        display.displayLine();
        previousStatus = KioskStatus.PRODUCT_MENU;
        switch (answer) {
            case -1 -> status = previousStatus;
            case 0 -> status = KioskStatus.MANAGER;
            default -> {
                if (products[answer - 1].getOption() != null) {
                    status = KioskStatus.PRODUCT_OPTION;
                } else {
                    status = KioskStatus.PRODUCT_ADD;
                }
                return products[answer - 1];
            }
        }
        return null;
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

    // 옵션 선택 화면
    public static Product controllProductOption(Product p) {
        int answer = input.receiveInput(2);
        Product temp = p;
        display.displayLine();
        previousStatus = KioskStatus.PRODUCT_OPTION;
        status = KioskStatus.PRODUCT_ADD;
        switch (answer) {
            case -1 -> status = previousStatus;
            case 0 -> status = KioskStatus.MANAGER;
            case 2 -> temp = p.pOption;
        }
        return temp;
    }
}
