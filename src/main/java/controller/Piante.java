package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.ProdottoBean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/Piante")
public class Piante extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProdottoBean> listaProdotti = new ArrayList<>();

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from prodotto where tipo = 'piante';");
            //order by data di immissione
            while (rs.next()) {

                ProdottoBean p = new ProdottoBean();
                p.setId_prodotto(rs.getInt(1));
                p.setNome_prodotto(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setImg(rs.getString(4));
                p.setDescrizione(rs.getString(5));
                p.setTipo(rs.getString(6));
                p.setQuantita(rs.getInt(7));
                listaProdotti.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("prodottiLista",listaProdotti);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/piante.jsp");
        dispatcher.forward(request, response);

    }

}
