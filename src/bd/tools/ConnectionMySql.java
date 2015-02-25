package bd.tools;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionMySql {
	
	public static Connection getMySQLConnection() throws SQLException
	{
		if(DBStatic.mysql_pooling==false)
		{
			return(DriverManager.getConnection("jdbc:mysql://"+DBStatic.mysql"))
		}
	}
	
}
