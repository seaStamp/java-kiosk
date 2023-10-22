import product.Menu;
import product.Product;

import java.util.Scanner;

public class Kiosk {
    private static int status;

    private static Menu[] menu = McMenu.mcMenu.clone();
    private static Product[] products;
    private static OutputDevice display = new OutputDevice();
    private Order orders = new Order();

    public boolean start() {
        display.displayCart(orders);

        return true;
    }
}
