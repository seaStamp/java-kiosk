package product;

public class Product extends Menu{
    private String productName;
    private double price;
    private int quantity = 0;


    public Product(String menuName, String productName, String info, double price){
        super(menuName, info);
        this.productName = productName;
        this.price = price;
        this.quantity++;
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
    public void increaseQuantity(){
        this.quantity++;
    }

    public void clearQuantity(){
        this.quantity = 1;
    }
}
