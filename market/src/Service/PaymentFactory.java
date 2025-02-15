package service;

import controller.payment.CashPayment;
import controller.payment.Card.CardPayment;
import controller.payment.Payment;

public class PaymentFactory {
    public static Payment createPayment(int type, String bookname) {
        switch (type) {
            case 1:
                return new CashPayment(bookname);
            case 2:
                return new CardPayment(bookname);
            default:
                throw new IllegalArgumentException("잘못된 결제 방식입니다.");
        }
    }
}
