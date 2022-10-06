package model;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {

    public void doSave(OrdineBean ordine) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ordine (id_utente,indirizzo,civico,cap,provincia,citta) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setInt(1, ordine.getId_utente());
            ps.setString(2, ordine.getIndirizzo());
            ps.setInt(3, ordine.getCivico());
            ps.setInt(4,ordine.getCap());
            ps.setString(5,ordine.getProvincia());
            ps.setString(6,ordine.getCitta());


            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id_ordine = rs.getInt(1);
            ordine.setId_ordine(id_ordine);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
