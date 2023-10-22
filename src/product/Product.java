package product;

public class Product extends Menu{
    private String productName;
    private double price;


    public Product(String menuName, String productName, String info, double price){
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
