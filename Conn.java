
package airlinemanagementsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Statement getStatement() throws SQLException {
    if (c == null || c.isClosed() || !c.isValid(2)) {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","user","password");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    if (s == null || s.isClosed()) {
        s = c.createStatement();
    }
    return s;
}

    
    public Conn(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","user","password");
            s = c.createStatement();
        }
        catch(Exception e){
        e.printStackTrace();
        }
        
    }
}
