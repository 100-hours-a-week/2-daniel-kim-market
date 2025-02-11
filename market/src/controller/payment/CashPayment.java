package controller.payment;

import service.PaymentThread;

//현금 결제 설정
public class CashPayment implements Payment { 
    private String bookname;
    
    public CashPayment(String bookname){
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
