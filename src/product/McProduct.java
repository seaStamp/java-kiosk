package product;

public class McProduct {
    // bugger
    private final static Bugger BIGMAC
            = new Bugger(McMenu.BUGGERS.getMenuName(), "Big Mac", "참깨빵 위에 순쇠고기 패티두장 특별한 소스, 양상추, 치즈, 피클 양파까지!", 6.0);
    private final static Bugger SANGHAI
            = new Bugger(McMenu.BUGGERS.getMenuName(), "Shanghai Burger", "겉은 바삭, 속은 부드러운 치킨 패티의 매콤함으로 입맛도 기분도 화끈하게!",
            6.0);
    private final static Bugger SHUSHU
            = new Bugger(McMenu.BUGGERS.getMenuName(), "Supreme Shrimp Burger", "탱~글한 통새우살이 가득 들어있는 슈슈버거!", 5.5);
    private final static Bugger BULGOGI
            = new Bugger(McMenu.BUGGERS.getMenuName(), "Bulgogi Burger",
            "한국인의 입맛에 딱 맞는 불고기소스에 잘재운 패티와 고소한 마요네즈, 신선한 양상추의 맛있는 조합.", 3.6);

    public static Bugger[] buggers = {BIGMAC, SANGHAI, SHUSHU, BULGOGI};
    // snack & side
    private final static Side FRECNCH_FRIES
            = new Side(McMenu.SIDES.getMenuName(), "French Fries", "맥도날드의 역사가 담긴 월드 클래스 후렌치 후라이", 2.8);
    private final static Side MCNUGGETS
            = new Side(McMenu.SIDES.getMenuName(), "McNuggets 4pc", "바삭하고 촉촉한 치킨이 한 입에 쏙!", 3.3);
    private final static Side CHEESE_STICK
            = new Side(McMenu.SIDES.getMenuName(), "Cheese Sticks 2pcs",
            "속이 꽉 찬 황금빛 바삭함! 자연 모짜렐라 치즈로 빈틈없이 고소한 맥도날드 치즈스틱!", 3.3);
    public static Side[] sides = {FRECNCH_FRIES, MCNUGGETS, CHEESE_STICK};
    // beverage
    private final static Beverage COKE
            = new Beverage(McMenu.BEVERAGES.getMenuName(), "Coca-Cola", "갈증해소 뿐만이 아니라 기분까지 상쾌하게! 코카-콜라", 2.4);
    private final static Beverage COKE_ZERO
            = new Beverage(McMenu.BEVERAGES.getMenuName(), "Coca-Cola Zero",
            "상쾌한 맛은 살리면서 웰빙 트렌드에 맞춰 설탕과 칼로리를 제로로 줄인 코카-콜라 제로", 2.4);
    private final static Beverage SPRITE
            = new Beverage(McMenu.BEVERAGES.getMenuName(), "Sprite", "청량함에 레몬, 라임향을 더한 시원함!", 2.4);
    public static Beverage[] beverages = {COKE, COKE_ZERO, SPRITE};
    // dessert
    private final static Dessert TAROPIE
            = new Dessert(McMenu.DESSERTS.getMenuName(), "Taro Pie", "달콤한 보라빛 디저트! 맥도날드 타로 파이", 2.5);
    private final static Dessert OREOMCFLURRY
            = new Dessert(McMenu.DESSERTS.getMenuName(), "Oreo McFlurry", "우유 듬뿍 신선한 아이스크림에 아삭아삭 오레오 쿠키가 가득!", 3.7);
    private final static Dessert CHOCOSUNDAE
            = new Dessert(McMenu.DESSERTS.getMenuName(), "Choco Sundae", "신선한 우유로 만든 아이스크림에 달콤한 초콜렛 시럽이 입안 가득", 2.8);

    public static Dessert[] desserts = {TAROPIE, OREOMCFLURRY, CHOCOSUNDAE};
}
