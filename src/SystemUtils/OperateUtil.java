package SystemUtils;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import DAOs.BaseDao;
import FunctionHelper.FindHelper;
import SystemClass.Flower;
import SystemClass.People;

/*
 * This class contains methods which support the operate table to run.
 * Specifically, it has "register", "login", "print all", "add to shopping cart", "delete from shopping cart",
 * 					"Confirm shopping", "add flower", "delete flower" methods.
 * 
 * 1. Register: 	Ask for user's information(username and password) and check it with the user table list.
 * 						if not, register successfully. Otherwise, ask again.
 * 
 * 2. Login: 		Ask for user's information(username and password) and check whether the user list has the username
 * 						if cannot find in the user list, ask input again.
 * 
 * 3. Print All: 	After user login successfully, flower information will be printed automatically.
 * 						Or when user want to see its shopping cart
 * 
 * 4. Add/Delete shopping cart: 	modify user's shopping cart, which is a hash table
 * 
 * 5. Confirm shopping: 			once the user confirms shopping, shopping cart will be printed in the console and
 * 										update information to the database.
 * 
 * 6. Add/Delete flower: 			Update the database information by manager.
 * 
 * 7. Confirm changing: 			once the manager confirms changing flower hash table will be printed in the console and
 * 										update information to the database.
 * 
 * 8. Shopping cart: it can references to history!!!
 * 
 * Preparation:
 * 		1. flower hash table: get data from flower data base and to assist to update flower data base after user/manager confirms.
 * 		2. user hash table: get data from user data base and to assist to update user data base after new user registered.
 * 		3. shopping/changing hash table: store temporary data and will assist in updating database after manager/user's confirmation.
 */
public class OperateUtil<T> {
	Scanner input = new Scanner(System.in);
	
	public static Map<String, Flower> flowerData = new Hashtable<>();
	public static Map<String, People> userData = new Hashtable<>();
	
	
	@SuppressWarnings("unchecked")
	public void initialize() throws Exception {
		BaseDao<T> initialDao = new BaseDao<T>();
		FindHelper findHelp = new FindHelper();
		flowerData = (Map<String, Flower>) initialDao.findEntity((T) findHelp.getFlowers());
		// userData = (Map<String, People>) initialDao.findEntity((T) findHelp.getUser());
	}
	
	/*
	 * 1. Ask for new user information
	 * 2. Check whether the new userName exists in the userData(hash table) by key
	 * 3. if exists, return back
	 * 4. Otherwise, add the new user into the hash table and utilize the insertEntity to update the user database
	 */
	public void register() {
		
	}
}
