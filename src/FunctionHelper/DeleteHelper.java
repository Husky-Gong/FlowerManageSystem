package FunctionHelper;

import java.util.Scanner;

import SystemClass.Flower;

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
}
