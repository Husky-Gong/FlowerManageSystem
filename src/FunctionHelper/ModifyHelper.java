package FunctionHelper;

import java.util.Map;
import java.util.Scanner;

import SystemClass.Flower;
import SystemClass.People;

/*
 * This class will act as a helper to generate modify sql
 * In this class, it has 
 * 
 * 1. one helper to create flower objects to modify flower table
 * 	  Specifically, it's to add flower information or delete flower information
 * 2. One helper to create user information
 * 	  it will help users change their information or register new user
 * 3. it will ask for every field in the object and 
 */
public class ModifyHelper {
	private Flower flwModifyHelper(Map<String,Flower> flowerMap) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Which kind flower do you want to modify? please input its name:");
		String flowerName = input.next();
		System.out.println("What's this flower's final number:");
		int flowerNum = input.nextInt();
		System.out.println("What's this flower's final price:");
		double flowerPrice = input.nextDouble();
		Flower flower = flowerMap.get(flowerName);
		flower.setStock(flowerNum);
		flower.setPrice(flowerPrice);
		return flower;
	}
	
	@SuppressWarnings("resource")
	private People userModifyHelper(Map<String,People> userMap) {
		Scanner input = new Scanner(System.in);
		System.out.println("Which user do you want to modify? please input its name:");
		String name = input.next();
		System.out.println("What's this user's new name:");
		String newName = input.next();
		System.out.println("What's this flower's new password:");
		String newPassword = input.next();
		People newUser = userMap.get(name);
		newUser.setName(newName);
		newUser.setPassWord(newPassword);
		return newUser;
	}
	
	public Flower flowerHelper(Map<String,Flower> flowerMap) {
		
		return flwModifyHelper(flowerMap);
	}
	
	public People userHelper(Map<String,People> userMap) {
		return userModifyHelper(userMap);
	}
}
