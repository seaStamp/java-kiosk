package model;

public class Product extends Menu {
    protected final String productName;
    private final double price;
    protected String option = null;
    private int quantity;
    private int totalQuantity = 0;
    public Product pOption = null;


    public Product(String menuName, String productName, String info, double price) {
        super(menuName, info);
        this.productName = productName;
        this.price = price;
        this.quantity = 0;
    }

    public Product(Product p, String option, double price) {
        super(p.menuName, p.info);
        this.productName = p.productName + "(" + option + ")";
        this.price = price;
        this.option = option;
        p.pOption = this;
    }
    public String getProductName() {
        return this.productName;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getOption(){
        return this.option;
    }
    public int getTotalQuantity() {
        return this.totalQuantity;
    }
    public void increaseQuantity() {
        this.quantity++;
    }

    public void clearQuantity() {
        this.quantity = 0;
    }

    public void saveQuantity() {
        this.totalQuantity += this.quantity;
    }
}
