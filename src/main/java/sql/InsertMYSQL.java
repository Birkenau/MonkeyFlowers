package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMYSQL {
    private Connection c;

    public InsertMYSQL(Connection c) {
        this.c = c;
    }

    public void insert(String sql){


        try	{

            PreparedStatement ps=c.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        }
        catch	(SQLException ex)	{
            System.out.println("Errore nell'insert");

            ex.printStackTrace();
        }

    }
}
