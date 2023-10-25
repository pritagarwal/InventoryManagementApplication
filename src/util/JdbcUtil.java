
package util;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil {

	private JdbcUtil() {
	}
	
	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
            
            
                FileInputStream fis = new FileInputStream("properties/application.properties");
		Properties properties = new Properties();
		properties.load(fis);
                String url=properties.getProperty("url");
                String username=properties.getProperty("username");
                String password=properties.getProperty("password");

		// Step2. Establish the Connection
		Connection connection = DriverManager.getConnection(url,username,password);
				
		//  Establish the Connection
		//Connection connection = DriverManager.getConnection("jdbc:mysql:///inventory", "root", "Prit123@");
		return connection;
	}

	public static void cleanUp(Connection con, Statement statement, ResultSet resultSet) throws SQLException {
		// Step6. Close the resources
		if (con != null) {
			con.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
}

