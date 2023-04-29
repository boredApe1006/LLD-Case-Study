package food_delivery_system.filters;

import food_delivery_system.data.FoodItem;
import food_delivery_system.data.Restaurant;
import food_delivery_system.data.StarRating;

public class StarRatingFilter implements FoodItemFilter, RestaurantFilter{

    private final StarRating rating;

    public StarRatingFilter(StarRating rating) {
        this.rating = rating;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal() >= rating.getVal();
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getRating().getVal() >= rating.getVal();
    }
}
