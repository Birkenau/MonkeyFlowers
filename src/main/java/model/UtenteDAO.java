package model;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

    private Connection sqlConn = null;
    private PreparedStatement statement = null;

    public void doSave(UtenteBean utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utenti (name , surname, email,password,via,civico,cap,regione,provincia) VALUES(?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setString(1, utente.getName());
            ps.setString(2, utente.getSurname());
            ps.setString(3, utente.getEmail());
            ps.setString(4, utente.getPassword());
            ps.setString(5,utente.getVia());
            ps.setInt(6,utente.getCivico());
            ps.setInt(7,utente.getCap());
            ps.setString(8,utente.getRegione());
            ps.setString(9,utente.getProvincia());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemove(int id){
    }

    public UtenteBean ricercaId(int x) throws SQLException{   //funxiona con la listaUtenti già presa dal db

        UtenteBean u = new UtenteBean();

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from utenti where id ="+x+";");
            while (rs.next()) {
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return u;

    }





    public UtenteBean ricercaNome(String x) throws SQLException{   //funxiona con la listaUtenti già presa dal db

        UtenteBean u = new UtenteBean();

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from utenti where email ="+x+";");
            while (rs.next()) {
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return u;

    }



}
