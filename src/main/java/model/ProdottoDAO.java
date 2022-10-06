package model;

import java.sql.*;

public class    ProdottoDAO {

    public ProdottoDAO() {
    }

    public static void doSave(ProdottoBean prodotto) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO prodotto(id_prodotto, nome_prodotto, prezzo, img , descrizione , tipo , quantita) VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prodotto.getId_prodotto());
            ps.setString(2, prodotto.getNome_prodotto());
            ps.setDouble(3, prodotto.getPrezzo());
            ps.setString(4, prodotto.getImg());
            ps.setString(5, prodotto.getDescrizione());
            ps.setString(6, prodotto.getTipo());
            ps.setInt(7, prodotto.getQuantita());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idProdotto = rs.getInt(1);
            prodotto.setId_prodotto(idProdotto);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ProdottoBean ricercaId(int x) throws SQLException {

        ProdottoBean p = new ProdottoBean();

        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from prodotto where id_prodotto =" + x + ";");
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
            throw new RuntimeException(e);
        }

        return p;

    }


    public ProdottoBean ricercaNome(String x) throws SQLException{

        ProdottoBean p = new ProdottoBean();

        try (Connection con = ConPool.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from prodotto where nome_prodotto='"+x+"'");
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
            throw new RuntimeException(e);
        }

        return p;

    }
}