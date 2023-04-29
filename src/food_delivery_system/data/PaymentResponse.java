package food_delivery_system.data;

public class PaymentResponse {
    private final double amount;
    private final int id;
    private final PaymentStatus status;

    public PaymentResponse(double amount, int id, PaymentStatus stutus) {
        this.amount = amount;
        this.id = id;
        this.status = stutus;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
