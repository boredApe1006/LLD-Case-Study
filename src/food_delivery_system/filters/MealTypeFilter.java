package food_delivery_system.filters;

import food_delivery_system.data.FoodItem;

import food_delivery_system.data.MealType;
import food_delivery_system.data.Restaurant;

public class MealTypeFilter implements FoodItemFilter, RestaurantFilter{

    private final MealType mealType;

    public MealTypeFilter(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getMealType().equals(mealType);
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getMealType().equals(mealType);
    }
}
