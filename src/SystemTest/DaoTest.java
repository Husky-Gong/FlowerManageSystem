package SystemTest;

import org.junit.Test;

import DAOs.BaseDao;
import FunctionHelper.InsertHelper;
import SystemClass.Flower;

public class DaoTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testInsertEntity() throws Exception{
		System.out.println("You are now testing Insert entity......");
		
		InsertHelper testInsert = new InsertHelper();
		Flower newFlower = testInsert.addNewFlw();
		
		BaseDao<T> testDao = new BaseDao<T>();
		int i = testDao.insertEntity((T) newFlower);
		
		System.out.println(i);
	}
}
