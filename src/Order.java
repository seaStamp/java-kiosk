import product.Product;

import java.util.ArrayList;

public class Order {
    private int id = 1;
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public int getId() {
        return this.id;
    }

    // 전체 금액
    public double getTotalCost() {
        double cost = 0;
        for (Product p : products) {
            cost += p.getPrice();
        }
        return cost;
    }

    // 추가한 상품의 갯수
    public int getOrderSize(){
        return this.products.size();
    }

    // 상품을 객체를 담는 메서드
    public void addProduct(Product p) {
        this.products.add(p);
    }

    public void upId(){
        this.id++;
    }
    public void orderClear() {
        this.products.clear();
    }
}


