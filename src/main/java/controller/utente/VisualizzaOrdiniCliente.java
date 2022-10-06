package controller.utente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.UtenteBean;
import model.OrdineBean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/VisualizzaOrdiniCliente")
public class VisualizzaOrdiniCliente extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<OrdineBean> listaOrdini = new ArrayList<>();

        try(Connection con = ConPool.getConnection()) {
            UtenteBean utenteLoggato = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
            Statement stmt = con.createStatement();
            int x=utenteLoggato.getId();

            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from ordine where id_utente =" + x + ";");
            while (rs.next()) {
                OrdineBean o = new OrdineBean();
                o.setId_ordine(rs.getInt(1));
                o.setId_utente(rs.getInt(2));
                o.setIndirizzo(rs.getString(3));
                o.setCivico(rs.getInt(4));
                o.setCap(rs.getInt(5));
                o.setProvincia(rs.getString(6));
                o.setCitta(rs.getString(7));

                listaOrdini.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("listaOrdini",listaOrdini);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaOrdiniCliente.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doGet(request,response);
    }

}
