package model;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDAO {

    public static void doSave(RecensioneBean recensione) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO recensione (prodotto,utente,voto,testo) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setInt(1, recensione.getProdotto());
            ps.setInt(2, recensione.getUtente());
            ps.setInt(3, recensione.getVoto());
            ps.setString(4,recensione.getTesto());



            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idrecensione = rs.getInt(1);
            recensione.setIdrecensione(idrecensione);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
