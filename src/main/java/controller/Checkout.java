package controller;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.ProdottoBean;
import model.ProdottoDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Checkout")
public class Checkout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Carrello cart = (Carrello) request.getSession().getAttribute("cart");


        List<ProdottoBean> lista = cart.getProdotti();
        request.getSession().setAttribute("prodottiCarrello",lista);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/checkout.jsp");
        dispatcher.forward(request, response);

    }

}
