package controller.payment.Card;

//Card 중 CheckCard 설정
public class CheckCard extends CardPayment {

    public CheckCard(String bookname) {
            super(bookname);
        }
    
        public void CalculatorPrice(){
        super.processPayment();
    }

    public void CompletePayment(){
        super.receiptPayment();
    }
}
