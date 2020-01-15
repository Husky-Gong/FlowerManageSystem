package SystemTest;

import org.junit.Test;

import DAOs.BaseDao;
import FunctionHelper.ModifyHelper;
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
	
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testModifyFunction() throws Exception {
		System.out.println("You are now testing modify function...");
		ModifyHelper flwHelp = new FunctionHelper.ModifyHelper();
		Flower newFlower = flwHelp.flowerHelper();
		BaseDao<T> testDao = new BaseDao<T>();
		int i = testDao.modifyEntity((T) newFlower);
		
		System.out.println(i);
	}
	
	@Test
	public <T> void testDeleteFunction() {
		System.out.println("You are now testing delete function......");
		mkSqlUtil mkSql = new mkSqlUtil();
		String sql = mkSql.createDeleteSQL(Flower.class);
		System.out.println(sql);
	}
}
