package model;

public class Menu {
    protected String menuName;
    protected String info;

    public Menu(String menuName, String info){
        this.menuName = menuName;
        this.info = info;
    }

    public String getMenuName() {
        return this.menuName;
    }
    public String getMenuInfo() {
        return this.info;
    }
}
