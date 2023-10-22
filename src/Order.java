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
            cost += (p.getPrice() * p.getQuantity());
        }
        return cost;
    }

    // 추가한 상품의 갯수
    public int getOrderSize() {
        return this.products.size();
    }

    // 상품을 객체를 담는 메서드
    public void addProduct(Product p) {
        int idx = products.indexOf(p);
        if (idx != -1) {
            p.increaseQuantity();
        } else {
            this.products.add(p);
        }
    }

    public void upId() {
        this.id++;
    }

    public void orderClear() {
        for(Product p : products){
            if(p.getQuantity() > 1){
                p.clearQuantity();
            }
        }
        this.products.clear();
    }
}