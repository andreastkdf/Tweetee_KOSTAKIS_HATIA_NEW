package bd.tools;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {
	private DataSource dataSource;
	
	//creation a l_aide d_un objet Database
	public Database(String jndiname) throws SQLException {
		try{
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env"+jndiname);
		}catch(NamingException e){
			//Handle error that it's not configured in JNDI.
			throw new SQLException(jndiname + " is missing in JNDI! : "+e.getMessage());
		}
	}
	
	//return new Connection to BD
	public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException{
	
		Class.forName("com.mysql.jdbc.Driver");
		DataSource dataSource = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/db");
		
		Connection connection = dataSource.getConnection();
		
		return connection;
	}
}
