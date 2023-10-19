public class Product extends Menu{
    private final String productName;
    private final double price;

    public Product(String menuName, String info, String productName, double price){
        super(menuName, info);
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getPrice() {
        return this.price;
    }
}
