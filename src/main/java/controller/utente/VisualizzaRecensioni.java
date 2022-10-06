package controller.utente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.RecensioneBean;
import model.UtenteBean;
import model.OrdineBean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/VisualizzaRecensioni")
public class VisualizzaRecensioni extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<RecensioneBean> listaRecensioni = new ArrayList<>();

        try(Connection con = ConPool.getConnection()) {
            UtenteBean utenteLoggato = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
            Statement stmt = con.createStatement();
            int x=utenteLoggato.getId();

            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from recensione where utente =" + x + ";");
            while (rs.next()) {
                RecensioneBean o = new RecensioneBean();
                o.setIdrecensione(rs.getInt(1));
                o.setProdotto(rs.getInt(2));
                o.setUtente(rs.getInt(3));
                o.setVoto(rs.getInt(4));
                o.setTesto(rs.getString(5));

                listaRecensioni.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("listaRecensioni",listaRecensioni);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaRecensioniCliente.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doGet(request,response);
    }

}
