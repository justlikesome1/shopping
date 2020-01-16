package com.woniuxy.exercises;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
	
	//rs:结果集，封装了我们需要封装的数据
	public List<T> getList(ResultSet rs, Class<T> clazz) throws Exception{
		
		List<T> l=new ArrayList<T>();
		//结果集的元数据
		ResultSetMetaData metaData=rs.getMetaData();
	
		//遍历结果集，行数据
	    while(rs.next()){
	    	//obj为要封装的实体类对象
	    	T obj=clazz.newInstance();
	    	
	    	//遍历行中的每一列
	        for(int i=1;i<=metaData.getColumnCount();i++){
	        	//获得每一列的列名
	        	String columnName=metaData.getColumnName(i);
	        	//根据列名拼接set方法
	        	String setMethodName="set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);
	        	//得到每一列的数据类型名称：INT|CHAR|VARCHAR
	        	String typeName=metaData.getColumnTypeName(i);
	        	
	        	//根据列名以及列的数据类型得到对应的set方法
	        	Method thod=null;
	        	if(typeName.equals("INT")){
	        		
	        		thod=clazz.getDeclaredMethod(setMethodName, int.class);
	        	}
	        	else if(typeName.equals("CHAR")||typeName.equals("VARCHAR")){
	        		
	        		thod=clazz.getDeclaredMethod(setMethodName, String.class);
	        	}
	        	
	        	else if(typeName.equals("FLOAT")){
	        		thod=clazz.getDeclaredMethod(setMethodName, float.class);
	        	}
	        	//得到结果集中每一列的值
	        	Object value=rs.getObject(columnName);
	            //调用obj对象的set方法，value为方法的实参
	        	thod.invoke(obj, value);
	        	
	        }
	        
	         //将对象放入集合
	        l.add(obj);
	        
	        
	    }
		return l;
		
	}
	
	
}
