package food_delivery_system.apis;

import food_delivery_system.data.Order;
import food_delivery_system.data.OrderStatus;
import food_delivery_system.data.User;
import food_delivery_system.managers.OrderManager;
import food_delivery_system.managers.UserManager;

public class UpdateOrderAPI {

    UserManager userManager = new UserManager();
    OrderManager orderManager = new OrderManager();
    public void updateOrder(int orderId, OrderStatus status, String userToken) {
        //....
        User user = userManager.getUserByToken(userToken);
        //
        Order order = orderManager.getOrder(orderId);

        if(status.equals(OrderStatus.COOKING))
            orderManager.setOrderToCooking(user,order);

    }
}
