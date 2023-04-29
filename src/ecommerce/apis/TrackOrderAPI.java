package ecommerce.apis;

import ecommerce.data.Order;
import ecommerce.data.OrderStatusDetails;
import ecommerce.data.User;
import ecommerce.db.DBAccessor;
import ecommerce.perm.Permission;
import ecommerce.perm.PermissionFactory;

import java.util.Optional;

public class TrackOrderAPI {
    public OrderStatusDetails trackOrder(int orderId, User user) {
        Order order = DBAccessor.getOrderById(orderId);
        if(order == null)
            throw new RuntimeException("Unable to fetch order");
        Optional<Permission> permission =
                PermissionFactory.getTrackOrderPermission(user,order);
        if(!permission.isPresent() || !permission.get().isPermitted())
            throw new RuntimeException("Action not allowed");
        return order.getOrderDetails();
    }
}
