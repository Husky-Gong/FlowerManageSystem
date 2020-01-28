package FunctionHelper;

import java.util.Scanner;

import SystemClass.Flower;
import SystemClass.People;

public class DeleteHelper {
	private Flower flwDeleteHelper() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the name you want to delete:");
		String flwName = input.next();
		Flower newFlower = new Flower(flwName);
		return newFlower;
	}
	
	public Flower deleteFlower() {
		return flwDeleteHelper();
	}
	
	private People userDeleteHelper() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the name you wwant to delete:");
		String userName = input.next();
		People newUser = new People(userName);
		return newUser;
	}
	
	public People deleteUser() {
		return userDeleteHelper();
	}
}
