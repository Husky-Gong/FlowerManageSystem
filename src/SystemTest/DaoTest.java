package SystemTest;
import java.util.Map;

import org.junit.Test;

import DAOs.BaseDao;
import FunctionHelper.DeleteHelper;
import FunctionHelper.FindHelper;
import FunctionHelper.InsertHelper;
import SystemClass.Flower;
import SystemClass.People;

public class DaoTest {
	/*
	 * ------------INSERT-------------
	 */
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
	public <T> void testInsertEntity2() throws Exception {
		System.out.println("You are now testing insert user entity......");
		
		InsertHelper testInsert = new InsertHelper();
		People newUser = testInsert.addNewUser();
		
		BaseDao<T> testDao = new BaseDao<T>();
		int i = testDao.insertEntity((T) newUser);
		
		System.out.println(i);
	}
	
	
/*
 * --------------GET ALL-------------
 * people and flower both work!
 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testFindEntity() throws Exception {
		System.out.println("You are now testing find entity......");
		FindHelper find = new FindHelper();
		BaseDao<T> testDao = new BaseDao<T>();
		
		Map<String,T> flwMap = testDao.findEntity((T) find.getFlowers());
		for(Map.Entry<String, T> entry: flwMap.entrySet()) {
			String key = entry.getKey();
			T obj = entry.getValue();
			System.out.println(key);
			System.out.println(obj);
			System.out.println("-------------");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testFindEntity2() throws Exception {
		System.out.println("You are now testing find user entity......");
		FindHelper find = new FindHelper();
		BaseDao<T> testDao = new BaseDao<T>();
		System.out.println("User table below:");
		Map<String,T> userMap = testDao.findEntity((T) find.getUser());
		for(Map.Entry<String, T> entry:userMap.entrySet()) {
			String key = entry.getKey();
			T obj = entry.getValue();
			System.out.println(key);
			System.out.println(obj);
			System.out.println("---------------");
		}
		
	}
	
	
/*
 * ----------------DELETE----------------
 * people and flower both work!
 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testDeleteEntity() throws Exception {
		System.out.println("You are now testing delete entity......");
		DeleteHelper deleteFlower = new DeleteHelper();
		BaseDao<T> testDao = new BaseDao<T>();
		int i = testDao.deleteEntity((T) deleteFlower.deleteFlower());
		System.out.println(i);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testDeleteEntity2() throws Exception {
		System.out.println("Your are now testing delete user entity......");
		DeleteHelper deleteUser = new DeleteHelper();
		BaseDao<T> testDao = new BaseDao<T>();
		int i = testDao.deleteEntity((T) deleteUser.deleteUser());
		System.out.println(i);
	}
}
