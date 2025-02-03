package Book;

import java.io.*;
import java.util.ArrayList;

public class BookBase {
    protected static final String FILE_NAME = "books.txt"; // 파일 이름
    protected ArrayList<Book> bookList; // 책 목록

    public BookBase() {
        bookList = new ArrayList<>();
        loadBooks();
    }

    // 책 데이터를 파일에 저장
    protected void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(bookList);
        } catch (IOException e) {
            System.out.println("책 데이터를 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 책 데이터를 파일에서 불러오기
    @SuppressWarnings("unchecked")
    protected void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            bookList = (ArrayList<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("기존 데이터 파일이 없습니다. 새로 생성합니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("책 데이터를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
