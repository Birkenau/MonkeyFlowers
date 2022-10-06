package controller;

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

@WebServlet("/VisualizzaRecensioniInfoProdotto")
public class VisualizzaRecensioniInfoProdotto extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<RecensioneBean> listaRecensioni = new ArrayList<>();

        try(Connection con = ConPool.getConnection()) {
            int id = Integer.parseInt(request.getParameter("idProd"));
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from recensione where prodotto =" + id + ";");
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaProdotto.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doGet(request,response);
    }

}
