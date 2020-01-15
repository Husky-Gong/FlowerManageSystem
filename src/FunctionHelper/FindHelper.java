package FunctionHelper;

import SystemClass.Flower;
import SystemClass.People;

public class FindHelper {
	private Flower flwFindHelper() {
		Flower newFlower = new Flower();
		return newFlower;
	}
	
	public Flower getFlowers() {
		return flwFindHelper();
	}
	
	private People userFindHelper() {
		People newUser = new People();
		return newUser;
	}
	
	public People getUser() {
		return userFindHelper();
	}
}
