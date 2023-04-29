package food_delivery_system.filters;

import food_delivery_system.data.CuisineType;
import food_delivery_system.data.FoodItem;
import food_delivery_system.data.Restaurant;

import java.util.List;

public class CuisinesTypeFilter implements FoodItemFilter, RestaurantFilter{
    private final List<CuisineType> cuisineTypes;

    public CuisinesTypeFilter( List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisineTypes.contains(foodItem.getCuisineType());
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        List<CuisineType> cuisines = restaurant.getCuisineTypes();
        for(CuisineType cuisineType: cuisineTypes) {
            if(cuisines.contains(cuisineType))
                return true;
        }
        return false;
    }
}
