package ecommerce.perm;

import ecommerce.data.Order;
import ecommerce.data.ProductCopy;
import ecommerce.data.User;

import java.util.Optional;

public class PermissionFactory {

    private PermissionFactory() { }

    public static Optional<Permission> getSearchPermission(User user) {
          // queryDB (We will check from db ki user has permission to search or not if not we will
                            // return optional empty otherwise permission;
          // construct and return permission
         return Optional.of(new SearchProductPermission(user));
    }

    public static Optional<Permission> getAddToCartPermission(User user, ProductCopy productCopy) {
        // queryDB
        // construct and return permission

        return Optional.of(new AddToCartPermission(user, productCopy));
    }

    public static Optional<Permission> getTrackOrderPermission(User user, Order order) {


        return Optional.of(new TrackOrderPermission( order , user));
    }

}
