package food_delivery_system.apis;

import food_delivery_system.data.CuisineType;
import food_delivery_system.data.MealType;
import food_delivery_system.data.Restaurant;
import food_delivery_system.data.StarRating;
import food_delivery_system.filters.CuisinesTypeFilter;
import food_delivery_system.filters.MealTypeFilter;
import food_delivery_system.filters.RestaurantFilter;
import food_delivery_system.filters.StarRatingFilter;
import food_delivery_system.searchers.RestaurantSearcher;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcherAPI {

    public List<Restaurant> searchRestaurant(String restaurantName, MealType mealType, List<CuisineType> cuisineTypes, StarRating rating) {

        // validations
        List<RestaurantFilter> filters = new ArrayList<>();
        if(mealType != null)
            filters.add(new MealTypeFilter(mealType));
        if(cuisineTypes != null)
            filters.add(new CuisinesTypeFilter(cuisineTypes));
        if(rating != null)
            filters.add(new StarRatingFilter(rating));
        return new RestaurantSearcher().search(restaurantName,filters);
    }
}
