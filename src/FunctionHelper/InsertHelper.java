package FunctionHelper;

import java.util.Scanner;

import SystemClass.Flower;
import SystemClass.People;

/*
 * This class will act as a helper to generate insert sql.
 * In this class, it has:
 * 
 * 1. One helper to create flower object which will be insert into the table
 * 	Specifically, this the insert function will only be called when the 
 * 	flower does NOT exist in the table. In other cases, the manager should call
 * 	the modify method in stead.
 * 
 * 2. One helper to create user object and insert it into the user table
 * 		this is used when a NEW user registers.
 */
public class InsertHelper {
	private Flower flwInsertHelper() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What kind of flower do you want to insert? please input its name:");
		String flowerName = input.next();
		System.out.println("How many flowers do you want to add?");
		int flowerNum = input.nextInt();
		System.out.println("Please set this flower's price:");
		double flowerPrice = input.nextDouble();
		Flower newFlower =new Flower(flowerName, flowerPrice, flowerNum);
		return newFlower;
	}
	
	public Flower addNewFlw() {
		return flwInsertHelper();
	}
	
	@SuppressWarnings("resource")
	private People userInsertHelper() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your username:");
		String userName = input.next();
		System.out.println("Input your password:");
		String passWord = input.next();
		System.out.println("What's your name:");
		String name = input.next();
		System.out.println("Money you want to deposit:");
		double money = input.nextDouble();
		People newUser = new People(userName, passWord, name, money, "user");
		return newUser;
	}
	
	public People addNewUser() {
		return userInsertHelper();
	}
}
