package controller.payment.Card;

import controller.payment.Payment;

public class CheckCard implements Payment {
    @Override
    public void processPayment() {
        System.out.println("💳 카드로 결제 진행 중...");
        //신용카드인지? 아니면 체크카드인지?
        //신용카드는 할부 가능
        //체크카드는 바로 결제
        //구매 하면 책 사라지는 건 그대로. -> 상위 클래스에 정의해도 될듯?
        System.out.println("✅ 카드 결제 완료!");
    }
}
