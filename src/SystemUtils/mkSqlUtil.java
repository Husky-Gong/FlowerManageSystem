package SystemUtils;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Map;

/*
 * This class contains multiple methods to create different SQL functions
 */
public class mkSqlUtil {
	/*
	 * SQL insert method:
	 * INSERT INTO tableName(c1,c2,...)
	 * VALUES (v1,v2,...);
	 */
	public String createInsertSQL(Class<?> clz) {
		Map<String,String> paraMap = getParams(clz);
		StringBuilder res = new StringBuilder(100);
		res.append("insert into ")
			.append(paraMap.get("tableName"))
			.append(paraMap.get("params"))
			.append(" VALUES ")
			.append(paraMap.get("preParams"));
		return res.toString();
	}

	public String createFindSQL(Class<?> clz) {
		Map<String,String> paraMap = getParams(clz);
		StringBuilder res = new StringBuilder(100);
		String params = paraMap.get("params");
		int endIndex = params.length()-2;
		res.append("select ")
				.append(params.substring(1, endIndex))
					.append(" from ")
						.append(paraMap.get("tableName"));
		return res.toString();
	}
	
	
	/* 1. Initialize the annotation and get parameter's table name
	 * if there is no default table name, 
	 * then use the class name as table name
	 * 
	 * 2. Insert variables in table
	 * 		- use getDeclaredFileds 
	 * 		- get variables from different class by its annotation
	 * 		- ignore variables which are read-only
	 * 		- connect 2 StringBuilder
	 */
	private Map<String,String> getParams(Class<?> clz) {
		Map<String,String> res = new Hashtable<>();
		
		StringBuilder params = new StringBuilder(50);
		StringBuilder preParams = new StringBuilder(50);
		String tableName;
		
		SystemAnnotation clzAnno = clz.getAnnotation(SystemAnnotation.class);
		tableName = clzAnno.tableName();
		if(tableName == null) tableName = clz.getSimpleName();
		
		String prefix = "";
		params.append("(");
		preParams.append("(");
		Field[] fields = clz.getDeclaredFields();
		for(Field var:fields) {
			params.append(prefix);
			preParams.append(prefix);
			prefix = ",";
			
			SystemAnnotation fieldAnno = var.getAnnotation(SystemAnnotation.class);
			String paramName = fieldAnno.columnName();
			if(paramName == null) paramName = var.getName();
			
			params.append(paramName);
			preParams.append("?");
		}
		params.append(")");
		preParams.append(")");
		
		res.put("params", params.toString());
		res.put("preParams", preParams.toString());
		res.put("tableName",tableName);
		
		return res;
	}
}

