package model.book;

import java.io.Serializable;

//현재는 get이지만 set을 추가하여 setter을 활용해 값을 입력/수정 하도록 하겠습니다.
public class Book implements Serializable {
    private String title;
    private String author;
    private int price;


    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "제목: " + title + ", 저자: " + author + ", 가격: " + price + "원";
    }
}
