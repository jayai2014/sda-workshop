package scripts;

import models.Book;
import models.ShoppingCart;
import temp.Persistance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="ViewCart", urlPatterns = "/view-cart")
public class ViewCart extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart cart = Persistance.getCart();

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Cart</h1>");
        writer.println("<ul>");
        for (Book book : cart.getBooks()) {
            writer.println("<li>" + book.toString() + "</li>");
        }
        writer.println("</ul>");
    }
}