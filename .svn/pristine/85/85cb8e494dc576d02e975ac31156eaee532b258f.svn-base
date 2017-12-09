package dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;

import dao.CategoryDao;
import domain.Category;

public class CategoryDaoImpl implements CategoryDao {
	
     public void add(Category c){
    	try{
    	 Connection con= JdbcUtils.getConnection();
    	 QueryRunner runner=new QueryRunner();
    	 String sql="insert into category(id,name,description)values(?,?,?)";
    	 Object params[]={c.getId(),c.getName(),c.getDescription()};
    	 runner.update(con, sql, params);
    	 
    	}catch(Exception e){
    		e.printStackTrace();
    	}
     }
     
     public Category find(String id){
    	 try{
        	 Connection con= JdbcUtils.getConnection();
        	 QueryRunner runner=new QueryRunner();
        	 String sql="select * from category where id=?";
        	 return(Category) runner.query(con, sql, id, new BeanHandler(Category.class));
        	 
        	}catch(Exception e){
        	  throw new RuntimeException();
        	}
     }
     
     public List getAll(){
    	 try{
        	 Connection con= JdbcUtils.getConnection();
        	 QueryRunner runner=new QueryRunner();
        	 String sql="select * from category";
        	 return(List) runner.query(con, sql,new BeanListHandler(Category.class));
        	 
        	}catch(Exception e){
        	  throw new RuntimeException();
        	}
     }
}
