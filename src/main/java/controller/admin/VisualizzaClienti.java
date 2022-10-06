package controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.ProdottoBean;
import model.UtenteBean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/VisualizzaClienti")
public class VisualizzaClienti extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<UtenteBean> listaUtenti = new ArrayList<>();

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from utenti where ruolo = 0;");
            while (rs.next()) {
                UtenteBean u = new UtenteBean();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setSurname(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setVia(rs.getString(6));
                u.setCivico(rs.getInt(7));
                u.setCap(rs.getInt(8));
                u.setRegione(rs.getString(9));
                u.setProvincia(rs.getString(10));
                listaUtenti.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("listaUtenti",listaUtenti);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/visualizzaUtenti.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doGet(request,response);
    }

}
