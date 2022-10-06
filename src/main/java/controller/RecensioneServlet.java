package controller;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/RecensioneServlet")
public class RecensioneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String action = request.getParameter("azione");

        if (action != null) {
            }if (action.equals("modifica3")) {
                int idModifica = Integer.parseInt(request.getParameter("idProdotto"));
                ProdottoDAO pdao = new ProdottoDAO();
                ProdottoBean p = new ProdottoBean();
                try {
                    p = pdao.ricercaId(idModifica);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("ProdottoMod", p);

            int idUtente = Integer.parseInt(request.getParameter("idUtente"));
            UtenteDAO odao = new UtenteDAO();
            UtenteBean o = new UtenteBean();
            try {
                o = odao.ricercaId(idUtente);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("utenteLoggato", o);


                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Recensione.jsp");
                dispatcher.forward(request, response);
            }else if(action.equals("modifica4")){


            int utente= Integer.parseInt(request.getParameter("utente"));
            int prodotto = Integer.parseInt(request.getParameter("prodotto"));
            int voto= Integer.parseInt(request.getParameter("voto"));
            String testo= request.getParameter("testo");

            RecensioneBean r = new RecensioneBean();

            r.setProdotto(prodotto);
            r.setUtente(utente);
            r.setVoto(voto);
            r.setTesto(testo);


            RecensioneDAO recensioneDAO = new RecensioneDAO();

            recensioneDAO.doSave(r);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/areaUtente.jsp");

            dispatcher.forward(request,response);








        }else {
                response.sendError(404);
            }
        }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
