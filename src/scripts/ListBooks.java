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
import java.util.ArrayList;

@WebServlet(name="ListBooks", urlPatterns = "/books")
public class ListBooks extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> books = Persistance.getBooks();

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Books</h1>");
        writer.println("<ul>");
        for (Book book: books) {
            writer.println("<li>" + book.toString() + "</li>");
        }
        writer.println("</ul>");
    }
}
