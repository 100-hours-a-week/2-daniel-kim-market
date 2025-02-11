package controller.payment;

public class CashPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("💰 현금으로 결제 진행 중...");
        //쓰레드 생성하기
        //내야할 금액 고지.
        //낼 금액 적기
        //낼 금액 비교하는 거 validator에 작성
        //금액 맞으면 구매 완료 후 책 삭제
        System.out.println("✅ 현금 결제 완료!");
    }
}
