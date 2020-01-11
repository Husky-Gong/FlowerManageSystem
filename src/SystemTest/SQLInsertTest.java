package SystemTest;

import org.junit.Test;

import SystemClass.Flower;
import SystemUtils.mkSqlUtil;

public class SQLInsertTest {
	@Test
	public void testInsertFunction() {
		mkSqlUtil sql = new mkSqlUtil();
		String insertSQL = sql.createInsertSQL(Flower.class);
		System.out.println(insertSQL);
	}
}
