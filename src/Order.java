import java.util.List;
import java.util.ArrayList;
public class Order {
    private int id = 0;
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public int getId(){
        return this.id;
    }

    // 전체 금액
    public double getTotalCost(){
        double cost = 0;
        for(Product p : products){
            cost += p.getPrice();
        }
        return cost;
    }

    // 상품을 객체를 담는 메서드
    public void addProduct(Product p){
        this.products.add(p);
    }
}


