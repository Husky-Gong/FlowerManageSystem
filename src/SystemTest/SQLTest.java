package SystemTest;

import org.junit.Test;

import SystemClass.Flower;
import SystemUtils.mkSqlUtil;

public class SQLTest {
	mkSqlUtil sql = new mkSqlUtil();
	
	@Test
	public void testInsertFunction() {
		String insertSQL = sql.createInsertSQL(Flower.class);
		System.out.println(insertSQL);
	}
	
	@Test
	public void testFindFunction() {
		String findSql = sql.createFindSQL(Flower.class);
		System.out.println(findSql);
	}
	
	@Test
	public void testModifyFunction() {
		String modifySql = sql.createModifySQL(Flower.class);
		System.out.println(modifySql);
	}
}
