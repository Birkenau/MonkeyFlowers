package controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.UtenteBean;
import model.UtenteDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.PrintWriter;
@WebServlet("/OperazioniCliente")
public class OperazioniCliente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String action = request.getParameter("azione");

        if (action != null) {
            if (action.equals("rimuovi")) {
                UtenteDAO u = new UtenteDAO();
                Integer id = Integer.parseInt(request.getParameter("idUtente"));
                try (Connection con = ConPool.getConnection()){
                    PreparedStatement preparedStmt = con.prepareStatement("delete from utenti  where id ="+id+";");
                    preparedStmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaClienti");
                dispatcher.forward(request, response);
            } else if (action.equals("modifica1")) {
                int idModifica = Integer.parseInt(request.getParameter("idUtente"));
                UtenteDAO udao = new UtenteDAO();
                UtenteBean u = new UtenteBean();
                try {
                    u = udao.ricercaId(idModifica);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("UtenteMod", u);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/modificaUtente.jsp");
                dispatcher.forward(request, response);
            }else if(action.equals("modifica2")){
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String via = request.getParameter("via");
                int civico = Integer.parseInt(request.getParameter("civico"));
                int cap = Integer.parseInt(request.getParameter("cap"));
                String regione = request.getParameter("regione");
                String provincia = request.getParameter("provincia");

                String query = "UPDATE `utenti` SET `name` ='"+name+"', `surname` = '"+surname+"', `email` = '"+email+"', `password` = '"+password+"', `via` = '"+via+"', `civico` = "+civico+", `cap` ="+cap+", `regione` ='"+regione+"', `provincia` ='"+provincia+"' WHERE (`id` ="+id+");";

                try (Connection con = ConPool.getConnection()){
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if( (UtenteBean)request.getSession().getAttribute("utenteLoggato")!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).getRuolo()==true) {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaClienti");
                    dispatcher.forward(request, response);
                }else{
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/areaUtente.jsp");
                    dispatcher.forward(request, response);

                }

            }else if(action.equals("daiRuolo")){

                String email = request.getParameter("email");


                //L'email esiste?



                String query = "UPDATE utenti SET ruolo = '1' WHERE (email = '"+email+"')";


                try (Connection con = ConPool.getConnection()){
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/areaAdmin.jsp");
                dispatcher.forward(request, response);

            }else {
                response.sendError(404);
            }
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

