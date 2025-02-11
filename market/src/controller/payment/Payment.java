package controller.payment;

// 부모 클래스 인터페이스 - 추상 메서드 + 일반 메서드를 모두 사용하기 위해 인터페이스로 제작.
public interface Payment {
    void processPayment(); // 결제 방식 안내 문구
    void receiptPayment(); // 영수증 -> 카드는 일반영수증, 현금은 현금영수증.

    //책이 얼마인지? -> 추후 장바구니 기능 추가를 위해 메서드 이름을 Calculator로 작성.
    default void CalculatorPrice(int price){
        System.out.println("내실 금액: " + price);
    }

    default void CompletePayment(){
        //결제 스레드로 이동.
        System.out.println("결제가 완료되었습니다.");
    }

}