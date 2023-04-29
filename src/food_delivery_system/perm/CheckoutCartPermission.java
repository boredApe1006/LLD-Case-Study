package food_delivery_system.perm;

import food_delivery_system.data.User;

public class CheckoutCartPermission implements Permission{

    private final User user;

    public CheckoutCartPermission(User user) {
        this.user = user;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
