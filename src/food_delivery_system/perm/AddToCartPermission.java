package food_delivery_system.perm;

import food_delivery_system.data.FoodItem;
import food_delivery_system.data.Restaurant;
import food_delivery_system.data.User;
import food_delivery_system.managers.DeliveryManager;
import food_delivery_system.searchers.RestaurantSearcher;

public class AddToCartPermission implements Permission{

    private final User user;
    private final FoodItem foodItem;
    private final DeliveryManager deliveryManager;

    public AddToCartPermission(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
        this.deliveryManager = new DeliveryManager();
    }

    @Override
    public boolean isPermitted() {
        if(!foodItem.isAvailable())
            return false;
        Restaurant restaurant = new RestaurantSearcher().searchById(foodItem.getRestaurantId());
        return deliveryManager.isDeliveryPossible(restaurant.getAddress() , user.getAddress());
    }
}
