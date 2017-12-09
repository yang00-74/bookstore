package dao.impl;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.JdbcUtils;
import dao.UserDao;
import domain.User;

public class UserDaoImpl implements UserDao {
     
	public void add(User u){
		try{
	       	 Connection con= JdbcUtils.getConnection();
	       	 QueryRunner runner=new QueryRunner();
	       	 String sql="insert into user(id,username,password,phone,address) values(?,?,?,?,?)";
	       	 Object params[]={u.getId(),u.getUsername(),u.getPassword(),u.getPhone(),u.getAddress()};
	       	 runner.update(con, sql, params);     	 
	       	}catch(Exception e){
	       		e.printStackTrace();
	       	}
	}
	public User find(String id){
		try{
	       	 Connection con= JdbcUtils.getConnection();
	       	 QueryRunner runner=new QueryRunner();
	       	 String sql="select * from user where id=?";	 
	       	 return (User)runner.query(con, sql, id,new BeanHandler(User.class));     	 
	       	}catch(Exception e){
	       		throw new RuntimeException(e);
	       	}		
	}
	public User find(String username,String password){
		try{
	       	 Connection con= JdbcUtils.getConnection();
	       	 QueryRunner runner=new QueryRunner();
	       	 String sql="select * from user where username=? and password=?";
	       	 Object params[]={username,password};
	       	 return (User)runner.query(con, sql, params,new BeanHandler(User.class));     	 
	       	}catch(Exception e){
	       		throw new RuntimeException(e);
	       	}		
	}
}
