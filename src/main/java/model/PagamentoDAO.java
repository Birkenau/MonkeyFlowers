package model;

import java.sql.*;

public class  PagamentoDAO {

    public PagamentoDAO() {
    }

    public void doSave(PagamentoBean metodo) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO metododipagamento (iban,scadenza,cvv,idutente) VALUES(?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente

            ps.setInt(1, metodo.getIban());
            ps.setString(2, metodo.getScadenza());
            ps.setString(3, metodo.getCvv());
            ps.setInt(4, metodo.getIdutente());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            metodo.setIdmetodo(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}