package controller.utente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteBean;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(name="registrazione-utente-servlet", value ="/registrazione-utente-servlet")
public class RegistraUtente extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String via = request.getParameter("via");
        int civico = Integer.parseInt(request.getParameter("civico"));
        int cap = Integer.parseInt(request.getParameter("cap"));
        String regione = request.getParameter("regione");
        String provincia = request.getParameter("provincia");

        UtenteBean u = new UtenteBean();

        u.setName(name);
        u.setSurname(surname);
        u.setEmail(email);
        u.setPassword(password);
        u.setVia(via);
        u.setCivico(civico);
        u.setCap(cap);
        u.setRegione(regione);
        u.setProvincia(provincia);

        UtenteDAO utenteDAO = new UtenteDAO();

        utenteDAO.doSave(u);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request,response);

    }

}
