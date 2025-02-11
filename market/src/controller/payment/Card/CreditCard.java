package controller.payment.Card;

//Card중 신용카드 설정
public class CreditCard extends CardPayment {

    public CreditCard(String bookname) {
            super(bookname);
        }
    
        public void Paymentment(){
        super.processPayment();
    }

    public void printreceipt(){
        super.receiptPayment();
    }
}