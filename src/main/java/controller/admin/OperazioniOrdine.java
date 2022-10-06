package controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OrdineDAO;
import model.OrdineBean;
import model.PagamentoBean;
import model.PagamentoDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/OperazioniOrdine")
public class OperazioniOrdine extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idUtente"));
        String indirizzo = request.getParameter("indirizzo");
        int civi = Integer.parseInt(request.getParameter("civico"));
        int ca = Integer.parseInt(request.getParameter("cap"));
        String prov = request.getParameter("provincia");
        String city = request.getParameter("citta");




        OrdineBean o = new OrdineBean();
        o.setId_utente(id);
        o.setIndirizzo(indirizzo);
        o.setCivico(civi);
        o.setCap(ca);
        o.setProvincia(prov);
        o.setCitta(city);

        OrdineDAO a = new OrdineDAO();

        a.doSave(o);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request,response);

    }

}
