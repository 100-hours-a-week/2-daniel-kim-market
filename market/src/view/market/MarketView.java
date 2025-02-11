package view.market;

import controller.book.BuyBookController;
import controller.book.SellBookController;
import service.BookService;
import service.BookManager;
import view.user.UserView;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class MarketView {
    private final SellBookController sellBookController;
    private final BuyBookController buyBookController;
    private final BookManager bookManager;
    private final Scanner scanner;

    public MarketView() {
        this.bookManager = new BookManager();
        BookService bookService = new BookService(bookManager);
        this.sellBookController = new SellBookController(bookService);
        this.buyBookController = new BuyBookController(bookService);
        this.scanner = new Scanner(System.in);
    }

    public void marketMenu(UserView userView) {
        AtomicBoolean isMarketRunning = new AtomicBoolean(true);

        while (isMarketRunning.get()) {
            System.out.println("\n=== 책 관리 프로그램 ===");
            System.out.println("[1] 책 판매 등록");
            System.out.println("[2] 판매중인 책 보기");
            System.out.println("[3] 책 구매");
            System.out.println("[4] 로그아웃");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    sellBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    buyBook();
                    break;
                case 4:
                    System.out.println("로그아웃 되었습니다.");
                    isMarketRunning.set(false);
                    userView.returnToUserMenu();
                    break;
                default:
                    System.out.println("올바른 선택이 아닙니다.");
            }
        }
    }

    private void sellBook() {
        sellBookController.handleSell();
    }

    private void listBooks() {
        if (bookManager.bookList.isEmpty()) {
            System.out.println("판매중인 책이 없습니다.");
        } else {
            System.out.println("판매중인 책 목록:");
            for (int i = 0; i < bookManager.bookList.size(); i++) {
                System.out.println((i + 1) + ". " + bookManager.bookList.get(i));
            }
        }
    }

    private void buyBook() {
        buyBookController.handlePurchase();
    }
}
