package SystemUtils;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XMLUtil {
	private static Document document;
	private static Map<String,String> netMap = new Hashtable<>();
	
	
	/*
	 * Initialize the reading configuration
	 * read XML file into Document object
	 */
	static {
		try(InputStream in = Thread.currentThread().
								getContextClassLoader().
								getResourceAsStream("NetInfo.xml")
				){
			if(in == null) throw new RuntimeException("Loading failed");
			
			SAXReader sr = new SAXReader();
			document = sr.read(in);
			load();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	
	/*
	 * Read the document and store information from XML file into a hashmap
	 */
	private static void load() {
		@SuppressWarnings("unchecked")
		List<Node> list = (List<Node>)document.selectNodes("sqlInfo//info");
		for(Node info: list) {
			String key = info.valueOf("@key");
			String value = info.valueOf("@value");
			netMap.put(key, value);
		}
	}
		
		
	/* Input net information key words, such as "userName", "passWord"...
	 * Return the corresponding value to key words.
	 */
	public String getNetInfo(String key) {
		return netMap.get(key);
	}
}
