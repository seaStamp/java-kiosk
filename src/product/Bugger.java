package product;

import model.Product;

public class Bugger extends Product {

    public Bugger bOption;

    public Bugger(String menuName, String productName, String info, double price) {
        super(menuName, productName, info, price);
        this.option = "Single";
    }

    public Bugger(Bugger b, String option, double price) {
        super(b,option,price);
    }
}
