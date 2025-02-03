package Book;

import java.util.Scanner;

public class SellBook {
    private BookManager manager; // BookManager 참조
    private Scanner scanner;

    public SellBook(BookManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    // 책 판매 추가
    public void addBook() {
        System.out.println("책 제목을 입력하세요:");
        String title = scanner.nextLine();

        System.out.println("저자를 입력하세요:");
        String author = scanner.nextLine();

        System.out.println("가격을 입력하세요:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // 버퍼 비우기

        manager.bookList.add(new Book(title, author, price));
        System.out.println("판매 정보가 등록되었습니다!");
        manager.saveBooks();
    }
}
