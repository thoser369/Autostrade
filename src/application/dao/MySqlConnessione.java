package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnessione extends Connessione{
	
	public static Connection createConnection() {
       	Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/autostrade","root","ciao123abcd");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return cn;
    }

	public MySqlConnessione() {
		// TODO Auto-generated constructor stub
	}


}
