package SystemTest;

import java.util.List;

import org.junit.Test;

import DAOs.BaseDao;
import FunctionHelper.FindHelper;
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
	
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testFindEntity() throws Exception {
		System.out.println("You are now testing find entity......");
		FindHelper findFlowers = new FindHelper();
		BaseDao<T> testDao = new BaseDao<T>();
		List<T> flwlist = testDao.findEntity((T) findFlowers.getFlowers());
		for(T var:flwlist) {
			System.out.println(var);
		}
	}
}
