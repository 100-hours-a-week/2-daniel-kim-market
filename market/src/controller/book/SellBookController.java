package controller.book;

import service.BookService;
import java.util.Scanner;
import util.Validator;

public class SellBookController {
    private BookService bookService;
    private Scanner scanner;
    private Validator validator;


    public SellBookController(BookService bookService) {
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    public void handleSell() {
        System.out.println("책 제목을 입력하세요:");
        String title = scanner.nextLine();
        System.out.println("저자를 입력하세요:");
        String author = scanner.nextLine();
        
        int price = -1; // while문으로 들어갈 수 있게 음수로 설정.
        while (price < 0) { // 가격이 유효할 때까지 반복
            try {
                System.out.println("가격을 입력하세요:");
                int input = scanner.nextInt();
                
                if (!validator.isUpDown(input)) { // 가격 유효성 검사 -> 잘 사용할지 생각해보기. validator에서 가져올건지, 아니면 여기에 직접 할건지?
                    System.out.println("잘못 입력했습니다. 5,000원 이상 5만원 이하로 입력하세요.");
                    price = -1; // 다시 입력받도록 설정
                }
                else{
                    scanner.nextLine();
                    price = input;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해야 합니다. 다시 입력하세요.");
            }
        }

        bookService.addBook(title, author, price);
        System.out.println("판매 정보가 등록되었습니다!");
    }
}
