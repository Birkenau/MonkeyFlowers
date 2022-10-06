package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMYSQL {
    private Connection c;

    public SelectMYSQL(Connection c) {
        this.c = c;
    }

    public ResultSet select(String sql) {

        try {


            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            return rs;
        } catch (SQLException ex) {
            System.out.println("Select error");
            System.out.println("SQLState:" + ex.getSQLState());
            ex.printStackTrace();
        }
        return null;
    }
}
