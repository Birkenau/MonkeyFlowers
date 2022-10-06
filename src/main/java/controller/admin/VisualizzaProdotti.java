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

@WebServlet("/VisualizzaProdotti")
public class VisualizzaProdotti extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProdottoBean> ProdDatabase = new ArrayList<>();

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from prodotto;");
            while (rs.next()) {
                ProdottoBean p = new ProdottoBean();
                p.setId_prodotto(rs.getInt(1));
                p.setNome_prodotto(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setImg(rs.getString(4));
                p.setDescrizione(rs.getString(5));
                p.setTipo(rs.getString(6));
                p.setQuantita(rs.getInt(7));
                ProdDatabase.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("ProdottiDatabase",ProdDatabase);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/visualizzaProdotti.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doGet(request,response);
    }

}
