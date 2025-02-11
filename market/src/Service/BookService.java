package service;

import model.book.Book;
import java.util.List;

public class BookService {
    private BookManager bookManager;

    public BookService(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    // 책 구매 로직
    public boolean purchaseBook(String title) {
        List<Book> books = bookManager.bookList;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                bookManager.saveBooks();
                return true;
            }
        }
        return false;
    }

    // 책 판매 로직
    public void addBook(String title, String author, int price) {
        bookManager.bookList.add(new Book(title, author, price));
        bookManager.saveBooks();
    }
}
