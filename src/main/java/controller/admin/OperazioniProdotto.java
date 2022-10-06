package controller.admin;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.ProdottoDAO;
import model.ProdottoBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/OperazioniProdotto")
public class OperazioniProdotto extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String action = request.getParameter("azione");

        if (action != null) {
            if (action.equals("rimuovi")) {
                ProdottoDAO p = new ProdottoDAO();
                Integer id = Integer.parseInt(request.getParameter("idProdotto"));
                try (Connection con = ConPool.getConnection()){
                    PreparedStatement preparedStmt = con.prepareStatement("delete from prodotto where id_prodotto ="+id+";");
                    preparedStmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaProdotti");
                dispatcher.forward(request, response);
            } else if (action.equals("modifica3")) {
                int idModifica = Integer.parseInt(request.getParameter("idProdotto"));
                ProdottoDAO pdao = new ProdottoDAO();
                ProdottoBean p = new ProdottoBean();
                try {
                    p = pdao.ricercaId(idModifica);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("ProdottoMod", p);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/modificaProdotto.jsp");
                dispatcher.forward(request, response);
            }else if(action.equals("modifica4")){
                int id_prodotto = Integer.parseInt(request.getParameter("id_prodotto"));
                String nome_prodotto = request.getParameter("nome_prodotto");
                double prezzo = Double.parseDouble(request.getParameter("prezzo"));
                String img = request.getParameter("img");
                String descrizione = request.getParameter("descrizione");
                String tipo = request.getParameter("tipo");
                int quantita = Integer.parseInt(request.getParameter("quantita"));


                String query = "UPDATE `prodotto` SET `nome_prodotto` ='"+nome_prodotto+"', `prezzo` = '"+prezzo+"', `img` = '"+img+"', `descrizione` = '"+descrizione+"', `tipo` = '"+tipo+"', `quantita` = "+quantita+" WHERE (`id_prodotto` ="+id_prodotto+");";

                try (Connection con = ConPool.getConnection()){
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaProdotti");
                dispatcher.forward(request, response);

            }else if(action.equals("aggiungiProdotto")) {

                String nome_prodotto = request.getParameter("nome_prodotto");
                double prezzo = Double.parseDouble(request.getParameter("prezzo"));
                String img = request.getParameter("img");
                String descrizione = request.getParameter("descrizione");
                String tipo = request.getParameter("tipo");
                int quantita = Integer.parseInt(request.getParameter("quantita"));

                ProdottoBean p = new ProdottoBean();

                p.setNome_prodotto(nome_prodotto);
                p.setPrezzo(prezzo);
                p.setImg(img);
                p.setDescrizione(descrizione);
                p.setTipo(tipo);
                p.setQuantita(quantita);

                ProdottoDAO prodottoDAO = new ProdottoDAO();

                try {
                    ProdottoDAO.doSave(p);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("/VisualizzaProdotti");

                dispatcher.forward(request,response);

            }else {
                response.sendError(404);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
