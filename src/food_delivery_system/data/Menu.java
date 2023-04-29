package food_delivery_system.data;

import java.util.List;

public class Menu {
    private final List<FoodItem> foodItems;

    public Menu(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }
}
