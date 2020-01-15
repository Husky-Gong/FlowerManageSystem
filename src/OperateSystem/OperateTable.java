package OperateSystem;

import java.util.Scanner;

import org.junit.Test;

import SystemUtils.OperateUtil;

public class OperateTable {
	static {
		
	}
	
	@Test
	public void table() throws Exception {
		Scanner input = new Scanner(System.in);
		
		OperateUtil opUtil = new OperateUtil();
		
		while(true) {
			opUtil.initialize();
			System.out.println("\t\t------Welcome to Flower System------\n Please make your choice:"
					+ "\t\t\t\t1. Resgister"
					+ "\t\t\t\t2. Login"
					+ "\t\t\t\t3. Exit");
			int choice = input.nextInt();
			switch(choice) {
				case 1:
					
			}
			
		}
	}
}
