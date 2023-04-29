package ecommerce.data;

public class OrderStatusDetails {

    private final OrderStatus orderstatus;
    private final String description;


    public OrderStatusDetails(String description , OrderStatus orderstatus) {
        this.description = description;
        this.orderstatus = orderstatus;
    }

    public OrderStatus getOrderstatus() {
        return orderstatus;
    }

    public String getDescription() {
        return description;
    }
}
