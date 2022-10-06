package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.ProdottoBean;
import model.RecensioneBean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/InfoProdotto")
public class InfoProdotto extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idProd"));
        ProdottoBean p = new ProdottoBean();

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from prodotto where id_prodotto="+id+";");  //order by data di immissione
            while (rs.next()) {
                p.setId_prodotto(rs.getInt(1));
                p.setNome_prodotto(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setImg(rs.getString(4));
                p.setDescrizione(rs.getString(5));
                p.setTipo(rs.getString(6));
                p.setQuantita(rs.getInt(7));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("prodottoPagina",p);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaProdotto.jsp");
        dispatcher.forward(request, response);

    }

}
