package DAOs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Map;

import SystemUtils.ConnectUtil;
import SystemUtils.SystemAnnotation;
import SystemUtils.mkSqlUtil;

/*
 * T represents it supports all styles of entity
 * UPDATE flower SET 
 * flower_name= ?,flower_column= ?,flower_number= ? 
 * WHERE 
 * flower_name=?
 * 
 * Here we don't need to pay attention to whether there are multiple connections,
 * because we have checked it when we create connUtil object.
 */

public class BaseDao<T> {
	
	/*
	 * This modifyEntity is to generate a complete SQL to modify
	 * information in the table. 
	 * This method is to help users change their password or username
	 * or to help managers change flower information
	 * ** the history is only available to search history purchase information
	 * ** this method only works when the input object exists.
	 * ** Add function need call another helper!!
	 * 1. Input: its input is an object. This object contains all 
	 * 				information which we want to replace '?' in prepared statement sql
	 * 2. Output: it returns how many lines in table will be modified
	 * 3. Steps:
	 * 		A. create connection;
	 * 		B. get prepared statement;
	 * 		C. analyze input object and get its values by reflection.
	 * 4. Because this modifying method is relied on the object's name
	 * 		to select which one to alter, we also get its name.
	 */
	public int modifyEntity(T type) throws  Exception {
		ConnectUtil connUtil = new ConnectUtil();
		Connection conn = connUtil.getConn();
		Class<?> clz = type.getClass();
		mkSqlUtil mkSql = new mkSqlUtil();
		String sql = mkSql.createModifySQL(clz);
		PreparedStatement ps = conn.prepareStatement(sql);
	
		int parameterIndex = 1;
		String whereInfo = null;
		for(Field field : clz.getDeclaredFields()) {
			SystemAnnotation an = field.getAnnotation(SystemAnnotation.class);
			if(an.readOnly()) continue;
			Method method = clz.getDeclaredMethod(an.getMethod());
			if(an.getMethod().contains("userName")|| an.getMethod().contains("FlowerName"))
				whereInfo = (String) method.invoke(type);
			
			Object obj = method.invoke(type);
			// setObject index starts from 1
			ps.setObject(parameterIndex++, obj);
		}
		if(whereInfo != null) ps.setObject(parameterIndex, whereInfo);
		return ps.executeUpdate();
	}
	
	public int insertEntity(T type) throws Exception {
		ConnectUtil connUtil = new ConnectUtil();
		Connection conn = connUtil.getConn();
		Class<?> clz = type.getClass();
		mkSqlUtil mkSql = new mkSqlUtil();
		String sql = mkSql.createInsertSQL(clz);
		PreparedStatement ps = conn.prepareStatement(sql);
		
		int parameterIndex = 1;
		for(Field field: clz.getDeclaredFields()) {
			SystemAnnotation an = field.getAnnotation(SystemAnnotation.class);
			if(an.readOnly()) continue;
			Method method = clz.getDeclaredMethod(an.getMethod());
			Object obj = method.invoke(type);
			ps.setObject(parameterIndex++, obj);
		}
		return ps.executeUpdate();
	}
	
	/*
	 * This method get one object and with this input object information
	 * 	1. we can get its field. With the annotation, we can get each field's corresponding column name and
	 * get each column's information.
	 *  2. Initialize one new object same as the input object's class
	 *  	!! USING 'clz.getConstructor().newInstance();'
	 * 	3. Using set method, which is also got by the annotation, to set each field in the new instance.
	 * 		!! When we use 'getDeclaredMethod' to get methods having parameters, 
	 * 			we have to put those parameters' classes after its method's name
	 * 
	 * 	4. In the while loop:
	 * 			a. To create a new object, which will be put into the result list.
	 * 			b. get information from each 'type'(the object)
	 * 			c. get each column name and by this column name to search the table
				d. column name --> set method --> complete new object
	 */
	@SuppressWarnings("unchecked")
	public Map<String,T> findEntity(T type) throws Exception{
		ConnectUtil connUtil = new ConnectUtil();
		Connection conn = connUtil.getConn();
		Map<String,T> map = new Hashtable<>();
		Class<?> clz = type.getClass();
		mkSqlUtil mkSql = new mkSqlUtil();
		String sql = mkSql.createFindSQL(clz);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			T obj = (T) clz.getConstructor().newInstance();
			Object keyName = null;
			for(Field field : clz.getDeclaredFields()) {
				SystemAnnotation an = field.getAnnotation(SystemAnnotation.class);
				String columnName = an.columnName();
				Object objVar = rs.getObject(columnName);
				if(columnName.equals("flower_name")||columnName.equals("user_userName")||columnName.equals("person_name"))
					keyName = objVar;
				Method method = clz.getDeclaredMethod(an.setMethod(),Object.class);
				method.invoke(obj, objVar);
			}
			map.put((String) keyName, obj);
		}
		return map;
	}
	
	
	/*
	 * Input: An object
	 * Output: Number of lines in SQL table infected
	 * Steps:
	 * 		1. Set connection
	 * 		2. Get sql statement(Prepared one)
	 * 		3. Analyze the object, get its corresponding table name and name
	 * 		4. Get complete sql statement and delete it from the table
	 * 
	 * !! Table name or column name cannot be wrapped by ' in sql statement !!
	 * !! PreparedStatement cannot be used to replace table name or column name !!
	 * !! Question mark in String 'replace' method should be added '\\' before it !!
	 */
	public int deleteEntity(T type) throws Exception {
		ConnectUtil connUtil = new ConnectUtil();
		Connection conn = connUtil.getConn();
		Class<?> clz = type.getClass();
		mkSqlUtil mkSql = new mkSqlUtil();
		PreparedStatement ps = null;
		String sql = mkSql.createDeleteSQL(clz);
		
		int parameterIndex = 1;
		String whereInfo = null;
		for(Field field : clz.getDeclaredFields()) {
			SystemAnnotation an = field.getAnnotation(SystemAnnotation.class);
			if(an.readOnly()) continue;
			
			Method method = clz.getDeclaredMethod(an.getMethod());
			if(an.getMethod().contains("UserName") || an.getMethod().contains("FlowerName")) {
				sql = sql.replaceFirst("\\?", an.columnName());
				ps = conn.prepareStatement(sql);
				whereInfo = (String) method.invoke(type);
				ps.setObject(parameterIndex, whereInfo);
				System.out.println(ps.toString());
				break;
			}
			if(ps == null) {
				System.out.println("Not exists!!");
				break;
			}
		}
		return ps.executeUpdate();
	}
}
