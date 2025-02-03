package Book;

import java.util.Scanner;

public class BuyBook {
    private BookManager manager; // BookManager 참조
    private Scanner scanner;

    public BuyBook(BookManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    // 책 구매
    public void buyBook() {
        System.out.println("구매할 책 제목을 입력하세요:");
        String title = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < manager.bookList.size(); i++) {
            if (manager.bookList.get(i).getTitle().equalsIgnoreCase(title)) {
                manager.bookList.remove(i);
                System.out.println("책을 구매하였습니다!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("해당 제목의 책이 없습니다.");
        }
        manager.saveBooks();
    }
}
