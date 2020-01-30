package SystemTest;

import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

import SystemClass.Flower;
import SystemUtils.OperateUtil;

public class OperateTest {
	@Test
	public <T> void initialTest() throws Exception {
		OperateUtil<T> opUtil = new OperateUtil<T>();
		opUtil.initialize();
		Map<String, Flower> flowerMap = new Hashtable<>();
		flowerMap = OperateUtil.flowerData;
		for(Map.Entry<String, Flower> entry : flowerMap.entrySet()) {
			String key = entry.getKey();
			Flower value = entry.getValue();
			System.out.println(key);
			System.out.println(value);
		}
	}
	
	
}
