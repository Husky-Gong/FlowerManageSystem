package SystemUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This class is to set connection between sql server and java program
 * It will use XMLUtil class as a helper
 * 
 * 		1. Use thread local to save cpu resource.
 * 		2. Provide public method to get prepared connection.
 */

public class ConnectUtil {
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	private XMLUtil readXML = new XMLUtil();
	private String userName = readXML.getNetInfo("userName");
	private String passWord = readXML.getNetInfo("passWord");
	private String url = readXML.getNetInfo("url");
	
	
	/*
	 * Check whether connection exists or not
	 */
	private Connection setConn() throws ClassNotFoundException, SQLException {
		Connection conn = threadLocal.get();

		if(conn == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, passWord);
		}
		return conn;
	}
	
	/*
	 * Provide public method.
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		return setConn();
	}
		
}
