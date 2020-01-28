package FunctionHelper;

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
	private Flower flwModifyHelper() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Which kind flower do you want to modify? please input its name:");
		String flowerName = input.next();
		System.out.println("What's this flower's final number:");
		int flowerNum = input.nextInt();
		System.out.println("What's this flower's final price:");
		double flowerPrice = input.nextDouble();
		Flower flower = new Flower(flowerName, flowerPrice, flowerNum);
		return flower;
	}
	
	private People userModifyHelper() {
		Scanner input = new Scanner(System.in);
		System.out.println("Which user do you want to modify? please input its name:");
		String flowerName = input.next();
		System.out.println("What's this user's new name:");
		String newName = input.next();
		System.out.println("What's this flower's new password:");
		String newPassword = input.next();
		People newUser = new Flower(flowerName, flowerPrice, flowerNum);
		return flower;
	}
	
	public Flower flowerHelper() {
		return flwModifyHelper();
	}
	
	public void userHelper() {
		userModifyHelper();
	}
}
