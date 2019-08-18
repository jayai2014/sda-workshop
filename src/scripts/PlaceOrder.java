package scripts;

import models.Book;
import models.Order;
import models.ShoppingCart;
import temp.Persistance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="PlaceOrder", urlPatterns = "/place-order")
public class PlaceOrder extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart cart = Persistance.getCart();
        Order order = cart.placeOrder();

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Your order invoice</h1>");
        writer.println("<ul>");
        for (Book book : order.getBooks()) {
            writer.println("<li>" + book.toString() + "</li>");
        }
        writer.println("</ul>");
        writer.println("Total: " + order.getTotal());
    }
}