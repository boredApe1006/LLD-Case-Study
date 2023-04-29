package food_delivery_system.apis;

import food_delivery_system.data.FoodItem;
import food_delivery_system.data.User;
import food_delivery_system.managers.CartManager;
import food_delivery_system.managers.UserManager;
import food_delivery_system.searchers.FoodItemSearcher;

public class AddToCartAPI {

    private final UserManager userManager = new UserManager();
    private final FoodItemSearcher foodItemSearcher = new FoodItemSearcher();

    private final CartManager cartManager = new CartManager();
    public void addToCart(String userToken, int foodItemId) {
       if(userToken == null || userToken.length() == 0 || foodItemId < 0) {
           //
       }
       User user = userManager.getUserByToken(userToken);
       if(user == null) {
          //
       }
        FoodItem foodItem = foodItemSearcher.searchById(foodItemId);
       if(foodItem == null) {

       }
       cartManager.addItemToCart(user,foodItem);
    }
}
