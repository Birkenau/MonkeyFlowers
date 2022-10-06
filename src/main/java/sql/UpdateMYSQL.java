package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMYSQL {
    private Connection c;

    public UpdateMYSQL(Connection c) {

        this.c = c;
    }

    public void update(String sql){

        try	{

            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException	ex)	{
            System.out.println("Update error");
            ex.printStackTrace();
        }
    }}
