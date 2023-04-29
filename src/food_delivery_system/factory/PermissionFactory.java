package food_delivery_system.factory;

import com.sun.org.apache.xpath.internal.operations.Or;
import food_delivery_system.data.FoodItem;
import food_delivery_system.data.Order;
import food_delivery_system.data.OrderStatus;
import food_delivery_system.data.User;
import food_delivery_system.perm.*;

public class PermissionFactory {
    private PermissionFactory() {}
    public static Permission getAddToCartPermission(User user, FoodItem fooditem) {
        return new AddToCartPermission(user, fooditem);
    }

    public static Permission getDeleteFromCartPermission(User user, FoodItem fooditem) {
        return new DeleteFromCartPermission(user, fooditem);

    }

    public static Permission getCheckOutCartPermission(User user) {

        return new CheckoutCartPermission(user);
    }

    public static Permission getPlacedOrderPermission(User user) {
        return new PlaceOrderPermission(user);
    }

    public static Permission getUpdateOrderPermission(User user, Order order, OrderStatus orderStatus) {
        return new UpdateOrderPermission(user,order, orderStatus);
    }
}
