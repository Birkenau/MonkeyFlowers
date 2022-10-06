package query;

import sql.DeleteMYSQL;

import java.sql.Connection;

public class QueryDelete {

    private Connection c;

    public QueryDelete (Connection c) {
        this.c=c;
    }

    public String deleteUtente(String CF){
        DeleteMYSQL delete = new DeleteMYSQL(c);
        String query = "DELETE FROM Utente WHERE CF = '" + CF + "'";
        delete.delete(query);

        return CF;
    }

    public int deleteCarrello(String CF, int idProdotto){
        DeleteMYSQL delete = new DeleteMYSQL(c);
        String query = "DELETE FROM Carrello WHERE CF = '" + CF+ "' AND id_prodotto = '" + idProdotto+"'";
        delete.delete(query);

        return idProdotto;
    }
}
