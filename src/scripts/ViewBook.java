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

@WebServlet(name="ViewBook", urlPatterns = "/view-book")
public class ViewBook extends HttpServlet {
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

        writer.println(book.toString());
    }
}
