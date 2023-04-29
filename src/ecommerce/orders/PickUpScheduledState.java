package ecommerce.orders;

import com.sun.org.apache.xpath.internal.operations.Or;
import ecommerce.data.DeliveryDetails;
import ecommerce.data.OrderStatusDetails;
import ecommerce.data.PickUpDetails;
import ecommerce.data.TransitDetails;

public class PickUpScheduledState implements OrderState {
    @Override
    public void schedulePickup(PickUpDetails pickupDetails) {

    }

    @Override
    public void pickup() {

    }

    @Override
    public void endTransit(TransitDetails transitDetails) {

    }

    @Override
    public void scheduleDelivery(DeliveryDetails deliveryDetails) {

    }

    @Override
    public void deliver() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public OrderStatusDetails getStatus() {
        return null;
    }
}
