import java.sql.Connection;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
Conn(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=  (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/unimanagement", "root", "Sami36");
        s=c.createStatement();


    }
    catch (Exception e){e.printStackTrace();}
}
}
