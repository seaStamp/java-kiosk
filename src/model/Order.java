package model;

import java.util.ArrayList;

public class Order {

    static private ArrayList<Product> totalProducts;
    private int id = 1;
    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public static ArrayList<Product> getTotalProducts() {
        return totalProducts;
    }

    public int getId() {
        return this.id;
    }

    public Order(){
        totalProducts = new ArrayList<>();
        products = new ArrayList<>();
    }
    // 전체 금액
    public double getTotalCost() {
        double cost = 0;
        for (Product p : products) {
            cost += (p.getPrice() * p.getQuantity());
        }
        return cost;
    }

    // 전체 판매한 상품 금액
    public static double getTotalProductsCost(){
        double cost = 0;
        for (Product p : totalProducts) {
            cost += (p.getPrice() * p.getTotalQuantity());
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
        p.increaseQuantity();
        if (idx == -1) {
            this.products.add(p);
        }
    }

    public void upId() {
        this.id++;
    }

    // 주문을 초기화하는 메서드
    public void orderClear() {
        for(Product p : products){
            if(p.getQuantity() > 0){
                p.clearQuantity();
            }
        }
        this.products.clear();
    }

    // 전체 주문내역을 저장하는 메서드
    public static void saveTotalProducts(ArrayList<Product> products){
        for(Product p : products ){
            int idx = totalProducts.indexOf(p);
            p.saveQuantity();
            if (idx == -1) {
                totalProducts.add(p);
            }
        }
    }
}