package Book;

import java.util.Scanner;

public class BookManager extends BookBase {
    private Scanner scanner;
    private SellBook sellBook;
    private BuyBook buyBook;

    public BookManager() {
        super(); // 부모 클래스(BookBase) 생성자 호출
        scanner = new Scanner(System.in);
        sellBook = new SellBook(this); // SellBook에 BookManager 참조 전달
        buyBook = new BuyBook(this);   // BuyBook에 BookManager 참조 전달
    }

    // 판매중인 책 목록 출력
    public void listBooks() {
        if (bookList.isEmpty()) {
            System.out.println("판매중인 책이 없습니다.");
        } else {
            System.out.println("판매중인 책 목록:");
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println((i + 1) + ". " + bookList.get(i));
            }
        }
    }

    // 메인 메뉴
    public void mainMenu() {
        while (true) {
            System.out.println("\n=== 책 관리 프로그램 ===");
            System.out.println("1. 책 판매 등록");
            System.out.println("2. 판매중인 책 보기");
            System.out.println("3. 책 구매");
            System.out.println("4. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    sellBook.addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    buyBook.buyBook();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 번호를 입력하세요.");
            }
        }
    }

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.mainMenu();
    }
}
