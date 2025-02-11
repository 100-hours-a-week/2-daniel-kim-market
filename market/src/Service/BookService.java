package service;

import model.book.Book;
import java.util.List;

public class BookService {
    private BookManager bookManager;

    public BookService(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    // 📌 책 가격 조회 기능 추가
    public int getPriceByTitle(String title) {
        List<Book> books = bookManager.bookList;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.getPrice();  // 📌 bookList에서 가격 가져오기
            }
        }
        return -1;  // 책이 없으면 -1 반환
    }

    // 📌 책 구매 로직 (책을 찾으면 제거)
    public boolean purchaseBook(String title) {
        List<Book> books = bookManager.bookList;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                bookManager.saveBooks();  // 파일 저장
                return true;
            }
        }
        return false;
    }

    // 📌 책 판매 로직 (책 추가 후 저장)
    public void addBook(String title, String author, int price) {
        bookManager.bookList.add(new Book(title, author, price));
        bookManager.saveBooks();
    }
}
