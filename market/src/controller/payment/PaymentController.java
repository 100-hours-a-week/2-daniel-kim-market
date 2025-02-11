package controller.payment;

import service.PaymentFactory;

//결제 타입과 책 제목을 받는다 -> 책 제목은 책의 금액을 파일에서 찾기 위해 제목을 가져오는데, 추후 수정하갰습니다.
public class PaymentController {
    public void processPayment(int type, String title) {
        Payment payment = PaymentFactory.createPayment(type, title);
        payment.processPayment();
    }
}