package OperateSystem;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import org.junit.Test;
import SystemClass.Flower;
import SystemClass.People;
import SystemUtils.OperateUtil;

public class OperateTable {
	static {
		
	}
	
	@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
	@Test
	public <T> void table() throws Exception {
		Scanner input = new Scanner(System.in);
		OperateUtil opUtil = new OperateUtil();
		Map<String, Flower> flowerMap = new Hashtable<>();
		People user = null;
		
		while(true) {
			// First initialize the database.
			opUtil.initialize();
			
			System.out.println("\t\t------Welcome to Flower System------\n Please make your choice:"
					+ "\t\t\t\t1. Regist"
					+ "\t\t\t\t2. Login"
					+ "\t\t\t\t3. Exit");
			int choice = input.nextInt();
			switch(choice) {
				case 1:
					opUtil.register();
					break;
				case 2:
					user = opUtil.login();
					break;
				case 3:
					OperateUtil.flag=false;
					System.out.println("See you!");
					System.exit(0);
					break;
			}
			
			while(OperateUtil.flag) {
				opUtil.initialize();
				System.out.println("\t\t------Welcome to Flower System------\n Please make your choice:"
						+ "\t\t\t\t1. Choose flower."
						+ "\t\t\t\t2. Return flower."
						+ "\t\t\t\t3. Add new flower."
						+ "\t\t\t\t4. Delete flower."
						+ "\t\t\t\t5. Change flower."
						+ "\t\t\t\t6. Pay."
						+ "\t\t\t\t7. Exit.");
				int decide = input.nextInt();
				
				switch(decide) {
					/*
					 * Case 1 is to buy flower 
					 * However, only update database after user confirms to buy
					 * Every time the customer bought something, this should be written into the flower hash table
					 * but there is only one customer in the system, so we only pay attention to the latest user.
					 */
					case 1:
						Map<String,T> map = opUtil.buyFlower(user);
						if(map == null) {
							break;
						}
						opUtil.printShopCart();
						/*
						 * Update flower hash table
						 */
						flowerMap.put(((Flower) map.get("flower")).getFlowerName(), (Flower) map.get("flower"));
						user = (People) map.get("user");
						break;
					case 6:
						opUtil.pay(flowerMap,user);
				}
			}
			
		}
	}
}
