package controller.payment.Card;

import controller.payment.Payment;
import service.PaymentThread;

public class CardPayment implements Payment {
    private String bookname;
    
    public CardPayment(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public void processPayment() {
        PaymentThread paymentThread = new PaymentThread(bookname);
        paymentThread.start();
    }

    @Override
    public void receiptPayment() {
        System.out.println("영수증을 출력하시겠습니까?");
    }
}
