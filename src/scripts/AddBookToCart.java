package scripts;

import models.Book;
import temp.Persistance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="AddBookToCart", urlPatterns = "/add-book-to-cart")
public class AddBookToCart extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String isbn = req.getParameter("isbn");

        if (isbn == null) {
            writer.println("Invalid request");
            return;
        }

        Book book = Persistance.getBook(isbn);

        if (book == null) {
            writer.println("No book found");
            return;
        }

        Persistance.addBookToCart(book);

        writer.println("Cart updated");
    }
}
