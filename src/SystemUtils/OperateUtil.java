package SystemUtils;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import DAOs.BaseDao;
import FunctionHelper.FindHelper;
import FunctionHelper.InsertHelper;
import FunctionHelper.logHelper;
import SystemClass.Flower;
import SystemClass.People;
import SystemTest.DaoTest;

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
	public static Map<String, Integer> shoppingCart = new Hashtable<>();
	public static boolean flag = false;
	
	static {
		shoppingCart.put("total", 0);
	}
	
	
	@SuppressWarnings("unchecked")
	public void initialize() throws Exception {
		BaseDao<T> initialDao = new BaseDao<T>();
		FindHelper findHelp = new FindHelper();
		flowerData = (Map<String, Flower>) initialDao.findEntity((T) findHelp.getFlowers());
		userData = (Map<String, People>) initialDao.findEntity((T) findHelp.getUser());
	}
	
	/*
	 * 1. Ask for new user information
	 * 2. Check whether the new userName exists in the userData(hash table) by key
	 * 3. if exists, return back
	 * 4. Otherwise, add the new user into the hash table and utilize the insertEntity to update the user database
	 */
	@SuppressWarnings("unchecked")
	public void register() throws Exception {
		System.out.println("Welcome our new user!");
		InsertHelper testInsert = new InsertHelper();
		People newUser = testInsert.addNewUser();
		BaseDao<T> testDao = new BaseDao<T>();
		
		while(userData.containsKey(newUser.getUserName())) {
			System.out.println("This username has existed, please change another one!");
			newUser = testInsert.addNewUser();
		}
		
		userData.put(newUser.getUserName(), newUser);
		int i = testDao.insertEntity((T) newUser);
		if(i==1) System.out.println("You have registered successfully!");
	}
	
	/*
	 *This function is used to help user log in
	 *After logging in, user can continue shopping and change its password or name.
	 *One flag is needed to identify whether this user has logged in.
	 */
	public People login() {
		System.out.println("----Log in----");
		logHelper log = new logHelper();
		Map<String, String> map = log.userLog();
		
		if(userData.containsKey(map.get("username")) 
				&& 
		   userData.get(map.get("username")).getPassWord().equals(map.get("password"))){
			flag = true;
			System.out.println("You login successfully!");
			return userData.get(map.get("username"));
		}
		else {
			System.out.println("Wrong username or password. Please try again!");
			return null;
		}
	}
	
	/*
	 * First print flower system for customers choosing.
	 * Every time customer chooses one flower, then update shopping cart
	 */
	@SuppressWarnings("resource")
	public People buyFlower(People user) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("------Purchase System------");
		DaoTest getFlower = new DaoTest();
		getFlower.testFindEntity();
		
		System.out.println("Which flower you want to buy?");
		String flowerName = input.next();
		System.out.println("How many you want to buy?");
		int flowerNum = input.nextInt();
		int newNum = shoppingCart.containsKey(flowerName)?flowerNum:shoppingCart.get(flowerName)+flowerNum;
		
		shoppingCart.put(flowerName, newNum);
		if((shoppingCart.get("total")+flowerData.get(flowerName).getPrice()*flowerNum)>user.getMoney()) {
			System.out.println("You don't have enough money! Please try again!");
			return user;
		}
		else {
			double money = user.getMoney()-flowerData.get(flowerName).getPrice()*flowerNum;
			userData.get(user.getUserName()).setMoney(money);
			return userData.get(user.getUserName());
		}
	}
	
	public void returnFlower() {
		
	}
	
	public void confirm() {
		Scanner input = new Scanner(System.in);
		System.out.println("-----Confirm your orders-----/n1. Yes/2. No");
		
	}
	
	public void printShopCart() {
		System.out.println("------Your shopping cart------/n/tFlower Name/t/tNumber");
		String total = "null/t/t0";
		for(Map.Entry<String, Integer> entry:shoppingCart.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if(!key.equals("total"))
				System.out.println(key+"/t/t"+value);
			else {
				total = key+"/t/t"+value;
			}
		}
		System.out.println(total);
	}
}
