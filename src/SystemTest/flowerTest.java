package SystemTest;

import org.junit.Test;

import SystemClass.Flower;

public class flowerTest {
	@Test
	public void flwTest() {
		Flower flw = new Flower();
		System.out.println(flw.getFlowerName());
	}
}
