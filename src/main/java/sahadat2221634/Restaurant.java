package sahadat2221634;

import java.util.List;

public class Restaurant {
    private String name;
    private List<FoodItem> menu;

    public Restaurant(String name, List<FoodItem> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public Restaurant getMenu() {
        return (Restaurant) menu;
    }

    @Override
    public String toString() {
        return name;
    }
}
