package FunctionHelper;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class logHelper {
	@SuppressWarnings("resource")
	private Map<String,String> userLogHelper() {
		Scanner input = new Scanner(System.in);
		Map<String, String> map = new Hashtable<>();
		
		System.out.println("Your username:");
		String userName = input.next();
		System.out.println("Your password:");
		String passWord = input.next();
		
		map.put("username", userName);
		map.put("password", passWord);
		
		return map;
	}
	
	public Map<String, String> userLog() {
		return userLogHelper();
	}
}
