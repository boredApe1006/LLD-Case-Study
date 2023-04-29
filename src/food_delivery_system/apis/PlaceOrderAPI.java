package food_delivery_system.apis;

import food_delivery_system.data.Order;
import food_delivery_system.data.PaymentResponse;
import food_delivery_system.data.PaymentStatus;
import food_delivery_system.data.User;
import food_delivery_system.factory.PaymentManagerFactory;
import food_delivery_system.managers.OrderManager;
import food_delivery_system.managers.PaymentManager;
import food_delivery_system.managers.UserManager;

import java.util.Map;

public class PlaceOrderAPI {

    private final UserManager userManager = new UserManager();
    private final OrderManager orderManager = new OrderManager();
    public Order placeOrder(String userToken, Map<String,String> paymentInfo, String paymentMode) {

        User user = userManager.getUserByToken(userToken);
        if (user == null)
            throw new IllegalArgumentException("userToken invalid");
        PaymentManager paymentManager = PaymentManagerFactory.getPaymentManager(paymentMode,paymentInfo);
        PaymentResponse paymentResponse = paymentManager.executePayment();
        if (paymentResponse == null || paymentResponse.getStatus() == null || paymentResponse.getStatus().equals(PaymentStatus.FAILED))
            throw new RuntimeException("payment failed.... ");
        return orderManager.placeOrder(user);
    }
}
