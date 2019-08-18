package temp;

import com.sun.tools.corba.se.idl.constExpr.Or;
import models.Book;
import models.Order;
import models.ShoppingCart;

import java.util.ArrayList;

public class Persistance {
    private static ArrayList<Book> books = createBooks();
    private static ShoppingCart cart = new ShoppingCart();
    private static ArrayList<Order> orders = new ArrayList<Order>();

    private static ArrayList<Book> createBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("1", "author", "book 1", "syllabus", 1));
        books.add(new Book("2", "author", "book 2", "syllabus", 1));
        return books;
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static Book getBook(String isbn) {
        for (Book book: books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }

        return null;
    }

    public static void addBookToCart(Book book) {
        cart.addBook(book);
        books.remove(book);
    }

    public static ShoppingCart getCart() {
        return cart;
    }

    public static void saveOrder(Order order) {
        orders.add(order);
    }
}
