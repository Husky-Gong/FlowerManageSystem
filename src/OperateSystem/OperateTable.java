package OperateSystem;

import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

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
						+ "\t\t\t\t1. Buy flower."
						+ "\t\t\t\t2. Return flower."
						+ "\t\t\t\t3. Add new flower."
						+ "\t\t\t\t4. Delete flower."
						+ "\t\t\t\t5. Change flower."
						+ "\t\t\t\t6. Exit.");
				int decide = input.nextInt();
				
				switch(decide) {
					/*
					 * Case 1 is to buy flower 
					 * However, only update database after user confirms to buy
					 */
					case 1:
						Map<String,T> map = opUtil.buyFlower(user);
						opUtil.printShopCart();
						break;
				}
			}
			
		}
	}
}
