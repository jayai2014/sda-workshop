package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Order {
    ArrayList<Book> books;

    public Order() {
        books = new ArrayList<>();
    }

    public void addBooksToOrder(ArrayList<Book> book) {
        this.books.addAll(book);
    }

    public int getTotal() {
        int sum = 0;

        for (Book book: books) {
            sum += book.price;
        }

        return sum;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
