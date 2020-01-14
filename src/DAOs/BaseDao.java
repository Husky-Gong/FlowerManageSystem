package DAOs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
