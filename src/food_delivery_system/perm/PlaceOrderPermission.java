package food_delivery_system.perm;

import food_delivery_system.data.User;

public class PlaceOrderPermission implements Permission{
    private final User user;

    public PlaceOrderPermission(User user) {
        this.user = user;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
