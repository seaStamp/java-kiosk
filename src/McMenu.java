import product.Menu;

public class McMenu {
    public final static Menu BUGGERS = new Menu("Buggers", "주문 즉시 바로 조리해 더욱 맛있는 맥도날드 버거!");
    public final static Menu SIDES = new Menu("Snacks & Sides", "가볍게 즐겨도, 버거와 함께 푸짐하게 즐겨도 좋은 사이트 메뉴!");
    public final static Menu BEVERAGES = new Menu("Beverages", "언제나 즐겁게, 맥카페와 다양한 음료를 부담없이 즐기세요!");
    public final static Menu DESSERTS = new Menu("Desserts", "달콤함의 향연! 달달한게 끌릴때는 맥도날드 디저트~");

    public static Menu[] mcMenu = {BUGGERS, SIDES, BEVERAGES, DESSERTS};
}
