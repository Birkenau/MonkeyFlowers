package query;

import sql.InsertMYSQL;

import java.sql.Connection;

public class QueryInsert {
    private Connection conn;

    public QueryInsert(Connection conn){
        this.conn = conn;
    }

    public void insertProdottoCarrello(String cfCliente, int idProdotto, int quantita){
        InsertMYSQL insert = new InsertMYSQL(conn);
        String query = "INSERT INTO Carrello(CF, id_prodotto, quantita) VALUES ('" + cfCliente+"', '"+idProdotto+"', '"+quantita+"')";
        insert.insert(query);
    }
}
