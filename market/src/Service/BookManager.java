package service;

import model.book.Book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final String FILE_NAME = "books.txt";
    public List<Book> bookList;

    public BookManager() {
        bookList = new ArrayList<>();
    }

    public void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(bookList);
        } catch (IOException e) {
            System.out.println("책 데이터를 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    public void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            bookList = (ArrayList<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("기존 데이터 파일이 없습니다. 새로 생성합니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("책 데이터를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
