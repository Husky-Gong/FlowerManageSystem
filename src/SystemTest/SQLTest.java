package SystemTest;

import org.junit.Test;

import SystemClass.Flower;
import SystemUtils.mkSqlUtil;

public class SQLTest {
	@Test
	public void testInsertFunction() {
		mkSqlUtil sql = new mkSqlUtil();
		String insertSQL = sql.createInsertSQL(Flower.class);
		System.out.println(insertSQL);
	}
	
	@Test
	public void testFindFunction() {
		mkSqlUtil sql = new mkSqlUtil();
		String findSql = sql.createFindSQL(Flower.class);
		System.out.println(findSql);
	}
}
