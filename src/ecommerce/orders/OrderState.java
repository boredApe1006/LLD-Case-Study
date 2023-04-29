package ecommerce.orders;

import ecommerce.data.DeliveryDetails;
import ecommerce.data.OrderStatusDetails;
import ecommerce.data.PickUpDetails;
import ecommerce.data.TransitDetails;

public interface OrderState {

    void schedulePickup(PickUpDetails pickupDetails);
    void pickup();
    void endTransit(TransitDetails transitDetails);
    void scheduleDelivery(DeliveryDetails deliveryDetails);
    void deliver();
    void cancel();
    OrderStatusDetails getStatus();
}
