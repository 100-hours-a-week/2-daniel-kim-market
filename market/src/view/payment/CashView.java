package view.payment;
import java.util.Scanner;

import model.book.Book;

public class CashView {
    private Book book;
    Scanner sc = new Scanner(System.in);

    public CashView(){

        System.out.println("💰 현금 결제 진행 중...");
        System.out.println("결제 금액: " + book.getPrice());
        System.out.print("내실 금액: ");
        sc.nextLine();

    }

    public void Cash(){
        
    }
}
