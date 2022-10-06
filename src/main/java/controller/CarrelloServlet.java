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


@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Carrello cart = (Carrello) request.getSession().getAttribute("cart");  //prendo il carrello dalla sessione



        if (cart == null) {  //se il carrello è vuoto ne crea uno nuovo e lo associa alla sessione con il nome "cart"
            cart = new Carrello();
            request.getSession().setAttribute("cart", cart);
        }

        List<ProdottoBean> lista = cart.getProdotti();
        request.getSession().setAttribute("prodottiCarrello",lista);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/carrello.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Carrello cart = (Carrello) request.getSession().getAttribute("cart");


        if (cart == null) {
            cart = new Carrello();
            request.getSession().setAttribute("cart", cart);
        }

        String action = request.getParameter("azione");//prende azione associata al parametro in sessione azione

        if (action != null) {
            if (action.equals("aggiungi")) {
                ProdottoDAO p = new ProdottoDAO();
                int x = Integer.parseInt(request.getParameter("idProdotto"));//recupero nome prodotto da aggiungere
                try {
                    cart.aggiungiProdotto(p.ricercaId(x));
                } catch (SQLException e) {
                    e.printStackTrace();
                }



            } else if (action.equals("rimuovi")) {
                ProdottoDAO p = new ProdottoDAO();
                String nome = (String) request.getParameter("nomeProdotto");//recupero nome prodotto da rimuovere

                try {
                    cart.rimuoviProdotto(p.ricercaNome(nome));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (action.equals("rimuoviTutto")) {
                cart.rimuoviTutto();
            }else {
                response.sendError(404);
            }
        }

        List<ProdottoBean> lista = cart.getProdotti();
        request.getSession().setAttribute("prodottiCarrello",lista);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/carrello.jsp");
        dispatcher.forward(request, response);

    }

}
