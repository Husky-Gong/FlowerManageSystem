package FunctionHelper;

import java.util.Scanner;

/*
 * This class will act as a helper to generate modify sql
 * In this class, it has 
 * 
 * 1. one helper to create flower objects to modify flower table
 * 	  Specifically, it's to add flower information or delete flower information
 * 2. One helper to create user information
 * 	  it will help users change their information or register new user
 */
public class ModifyHelper {
	private void flwModifyHelper() {
		Scanner input = new Scanner(System.in);
		System.out.println("Which kind flower do you want to modify? please input its name:");
		String flowerName = input.next();
		
	}
	
	private void userModifyHelper() {
		
	}
	
	public void flowerHelper() {
		flwModifyHelper();
	}
	
	public void userHelper() {
		userModifyHelper();
	}
}
