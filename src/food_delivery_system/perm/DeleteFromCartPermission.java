package food_delivery_system.perm;

import food_delivery_system.data.FoodItem;
import food_delivery_system.data.User;

public class DeleteFromCartPermission implements Permission{

    private final User user;
    private final FoodItem foodItem;

    public DeleteFromCartPermission(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
