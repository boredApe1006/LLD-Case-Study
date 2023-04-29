package food_delivery_system.filters;

import food_delivery_system.data.FoodItem;

public interface FoodItemFilter {

    boolean filter(FoodItem foodItem);
}
