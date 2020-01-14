package DAOs;

import org.junit.Test;

import SystemClass.Flower;

public class Testhelper {
	@Test
	public void main() {
		Flower newFlower = new Flower();
		System.out.println(newFlower);
		System.out.println(newFlower.getClass());
	}
}
