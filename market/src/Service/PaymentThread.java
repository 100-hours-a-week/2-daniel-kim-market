package service;

import java.util.Scanner;
import util.Validator;

public class PaymentThread extends Thread {
    private BookService bookService;
    private String bookname;
    private Scanner sc;
    private Validator validator;

    public PaymentThread(String bookname) {
        this.bookname = bookname;
        this.sc = new Scanner(System.in);
        this.validator = new Validator();
    }

    @Override
    public void run() {
        System.out.println("구매하실 책: " + bookname);
        System.out.println("카드로 결제 진행 중...");

        int price = bookService.getPriceByTitle(bookname);
        if (price == -1) {
            System.out.println("책 정보를 찾을 수 없습니다: " + bookname);
            return;
        }
        
        System.out.println("💰 내실 금액: " + price + "원");

        while (true) {
            System.out.print("지불 금액: ");
            int myprice = sc.nextInt();

            if (validator.isCanPayment(price, myprice)) {
                System.out.println("결제 요청 처리 중...");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("결제 오류 발생!");
                    return;
                }

                System.out.println("카드 결제 완료!");
                System.out.println("책 구매 완료! 도서가 배송 준비 중입니다.");
                break;
            } else {
                System.out.println("결제 실패: 금액이 부족합니다. 다시 입력해주세요.");
            }
        }
    }
}
