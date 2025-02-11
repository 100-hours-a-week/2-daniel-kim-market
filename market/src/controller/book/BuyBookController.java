package controller.book;

import service.BookService;
import java.util.Scanner;
import view.payment.PaymentView;

//책을 구매하는 컨트롤러
public class BuyBookController {
    private BookService bookService;
    private Scanner scanner;
    private PaymentView paymentView;

    public BuyBookController(BookService bookService) {
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
        this.paymentView = new PaymentView();
    }

    //구매할 책이 있는지 확인하고 책을 구매.
    public void handlePurchase() {
        System.out.println("구매할 책 제목을 입력하세요:");
        String title = scanner.nextLine();
        paymentView.PaymentMenu(title);             //책이 있는지 찾아보기
        if (bookService.purchaseBook(title)) {
            System.out.println("책을 구매하였습니다!");
        } else {
            System.out.println("해당 제목의 책이 없습니다.");
        }
    }
}
