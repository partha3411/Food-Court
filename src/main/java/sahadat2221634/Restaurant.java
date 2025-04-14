package sahadat2221634;

import java.util.List;

public class Restaurant {
    private final String name;
    private final List<FoodItem> menu;

    public Restaurant(String name, List<FoodItem> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return name;
    }
}
