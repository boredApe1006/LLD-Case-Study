package ecommerce.data;

import ecommerce.orders.OrderState;


public class Order {
    private final int id;
    private final Cart cart;
    private final Address shippingAddress;
    private final Address billingAddress;

    private OrderState orderState;

    public OrderState getOrderState() {
        return orderState;
    }

    public Order(int id, Cart cart, Address shippingAddress, Address billingAddress) {
        this.id = id;
        this.cart = cart;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public int getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void schedulePickup(PickUpDetails pickUpDetails) {
        this.orderState.schedulePickup(pickUpDetails);
    }
    public void cancel() {
        this.orderState.cancel();
    }

    public void pickUp() {
        this.orderState.pickup();
    }

    public void endTransit(TransitDetails transitDetails) {
        this.orderState.endTransit(transitDetails);
    }

    public OrderStatusDetails getOrderDetails() {
        return this.orderState.getStatus();
    }
}
