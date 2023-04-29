package food_delivery_system.apis;

import food_delivery_system.data.FoodItem;
import food_delivery_system.searchers.FoodItemSearcher;

public class GetFoodItemByIdAPI {
    public FoodItem getFoodItemById(int id) {
        if(id < 0) {
            //
        }
        return new FoodItemSearcher().searchById(id);
    }
}
