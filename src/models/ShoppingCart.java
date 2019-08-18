package models;

import temp.Persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Book> books;

    public ShoppingCart() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        this.books.put(book.isbn, book);
    }

    public ArrayList<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public Order placeOrder() {
        Order order = new Order();
        order.addBooksToOrder(getBooks());
        books.clear();

        Persistance.saveOrder(order);
        return order;
    }
}
