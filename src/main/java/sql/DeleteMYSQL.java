package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMYSQL{
    private Connection c;

    public DeleteMYSQL(Connection c) {
        this.c = c;
    }


    public void delete(String sql){
        try	{

            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException	ex)	{
            System.out.println("Delete error");
            ex.printStackTrace();
        }
    }
}
