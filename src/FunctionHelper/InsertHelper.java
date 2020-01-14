package FunctionHelper;

import java.util.Scanner;

import SystemClass.Flower;

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
}
