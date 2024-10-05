package org.example;



public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String placeOrder(String orderId, double amount) {
        boolean paymentSuccessful = paymentService.processPayment(orderId, amount);
        if (paymentSuccessful) {
            return "Order Placed";
        } else {
            return "Order Failed";
        }
    }
}
