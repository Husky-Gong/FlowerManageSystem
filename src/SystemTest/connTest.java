package SystemTest;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import SystemUtils.ConnectUtil;

public class connTest {
	@Test
	public void testConnection() throws ClassNotFoundException, SQLException {
		ConnectUtil connUtil = new ConnectUtil();
		Connection conn = connUtil.getConn();
		System.out.println(conn);
	}
}
