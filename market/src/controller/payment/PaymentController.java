package controller.payment;

import service.PaymentFactory;

public class PaymentController {
    public void processPayment(int type) {
        Payment payment = PaymentFactory.createPayment(type);
        payment.processPayment();  // ✅ 다형성을 활용하여 결제 실행
    }
}