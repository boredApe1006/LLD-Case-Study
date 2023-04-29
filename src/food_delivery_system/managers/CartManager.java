package food_delivery_system.managers;

import food_delivery_system.data.*;
import food_delivery_system.factory.PermissionFactory;
import food_delivery_system.perm.Permission;

import java.util.List;

public class CartManager {

    public List<CartItem> getUserCart(User user) {

        DataAccessResult dataAccessResult = DataAccessor.getCart(user);
        return DataAccessObjectConvertor.convertToCartItems(dataAccessResult);
    }

    // adds 1 unit
    public void addItemToCart(User user, FoodItem foodItem) {
        Permission permission = PermissionFactory.getAddToCartPermission(user,foodItem);
        if(!permission.isPermitted())
            throw new RuntimeException("Permission Denied");

        if(!isFoodItemFromSameRestaurant(user,foodItem))
            throw new RuntimeException("Your cart contains items from diff restaurant");
        DataAccessor.addItemToCart(user , foodItem);
    }

    public void deleteFromCart(User user, FoodItem foodItem) {

        Permission permission = PermissionFactory.getDeleteFromCartPermission(user,foodItem);
        if(!permission.isPermitted())
            throw new RuntimeException("Permission Denied");

        if(!isFoodItemPresentInCart(user,foodItem))
            throw new RuntimeException("fooditem not in cart");

        DataAccessor.deleteItemFromCart(user, foodItem);
    }

    public void checkOutUserCart(User user) {
        Permission permission = PermissionFactory.getCheckOutCartPermission(user);
        if(!permission.isPermitted())
            throw new RuntimeException("Permission Denied");
        if(isCartEmpty(user))
            throw new RuntimeException("cart empty");

        DataAccessor.checkOutCart(user);
    }

    private boolean isFoodItemFromSameRestaurant(User user, FoodItem foodItem) {
        List<CartItem> cartItems = getUserCart(user);
        return cartItems.isEmpty() || (cartItems.get(0).getFoodItem().getRestaurantId() == foodItem.getRestaurantId())
    }

    private boolean isFoodItemPresentInCart(User user, FoodItem foodItem) {
        List<CartItem> cartItems = getUserCart(user);
        for (CartItem item: cartItems) {
            if(item.getFoodItem().getId() == foodItem.getId())
                return true;
        }
        return false;
    }

    private boolean isCartEmpty(User user) {
        List<CartItem> cartItems = getUserCart(user);
        return cartItems.isEmpty();
    }
}
// Cart
// cart_id, id, user_id, food_item_id , qty, status
// Permission
// Systems : diff levels of access
// R W EX
// Permission abstract
// AWS
// User user, Permission perm
//Orders
//
// order_id, cart_id