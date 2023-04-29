package food_delivery_system.apis;

import food_delivery_system.data.CuisineType;
import food_delivery_system.data.FoodItem;
import food_delivery_system.data.MealType;
import food_delivery_system.data.StarRating;

import java.util.List;

public class FoodItemSearcherAPI {

    public List<FoodItem> searchFoodItems(String foodItemName, MealType mealType, List<CuisineType> cuisines,
                                          StarRating rating) {
            return null;
    }

}
// Searcher : Generic
// Get only those food items whose (name matches foodItemName) AND (mt is mealType) AND (CT in cuisines) AND (r > RATING)
// FILTER F1 F2 F3
// --foodItem--> F --T/F-->
// List of foodItems
// Filter