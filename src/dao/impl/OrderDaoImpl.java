package dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;
import dao.OrderDao;
import domain.Book;
import domain.Order;
import domain.OrderItem;
import domain.User;

public class OrderDaoImpl implements OrderDao {
       public void add(Order o){
    	   try{
  	       	 Connection con= JdbcUtils.getConnection();
  	       	 QueryRunner runner=new QueryRunner();
  	       	String sql="insert into orders(id,ordertime,state,price,user_id) values(?,?,?,?,?)";
  	       	Object params[]={o.getId(),o.getOrdertime(),o.isState(),o.getPrice(),o.getUser().getId()}; 
  	       	runner.update(con, sql, params);
  	       	
  	        Set<OrderItem> set=o.getOrderitems();
  	        for(OrderItem item:set){
  	        	sql="insert into orderitem(id,quantity,price,book_id,order_id) values(?,?,?,?,?)";
  	            params=new Object[]{item.getId(),item.getQuantity(),item.getPrice(),item.getBook().getId(),o.getId()};
                runner.update(con, sql, params);  	        
  	        }
  	       	
  	       	}catch(Exception e){
  	       		e.printStackTrace();
  	       	}
       }
       
       public Order find(String id){
    	   try{
	            	 Connection con= JdbcUtils.getConnection();
	            	 QueryRunner runner=new QueryRunner();
	            	 
	            	 //找订单信息
	            	 String sql="select * from orders where id=?";
	            	  Order order= (Order)runner.query(con, sql, id,new BeanHandler<Object>(Order.class)); 
	            	  
	            	  //找出order中每一个订单项
	            	  sql="select * from orderitem where order_id=?";
	            	  List<OrderItem> list=runner.query(con, sql, id, new BeanListHandler(OrderItem.class));	  
	            	  //把订单项全部加入OrderItems中
	            	  order.getOrderitems().addAll(list); 
	            	  
	            	  //找出每个订单项中的书
	            	  for(OrderItem item:list){
	            		  sql="select b.* from orderitem oi,book b where oi.id=? and b.id=oi.book_id";
	            		 Book book= (Book)runner.query(con, sql, item.getId(),new BeanHandler(Book.class));
	            		 item.setBook(book);
	            	  }       
	            	  
	            	  //找下订单的用户
	            	  sql="select u.* from orders o,user u where o.id=? and u.id=o.user_id";
	            	  User user=(User)runner.query(con, sql, id, new BeanHandler<Object>(User.class));
	            	  
	            	  order.setUser(user);
	            	  return order;
	            	  
    	   }catch(Exception e){
            	 throw new RuntimeException(e);
            	}
       }
       
       //state :true 已经发货
       public List<Order> getAll(boolean state){
    	   try{
            	 Connection con= JdbcUtils.getConnection();
            	 QueryRunner runner=new QueryRunner();
            	 
            	 String sql="select * from orders where state=?";
            	 List<Order>list=(List<Order>)runner.query(con, sql,state, new BeanListHandler(Order.class));     	 
            	
            	 for(Order o:list){
            		  sql="select u.* from orders o,user u where o.id=? and u.id=o.user_id";
	            	  User user=(User)runner.query(con, sql, o.getId(), new BeanHandler<Object>(User.class));
	            	  o.setUser(user);
            	 }
            	 return list;
    	   }catch(Exception e){
            	 throw new RuntimeException(e);
            	}
       }
       public void update(String id,boolean state){
    	   try{
          	 Connection con= JdbcUtils.getConnection();
          	 QueryRunner runner=new QueryRunner();
          	 
          	 String sql="update orders set state=? where id=?";
          	 Object params[]={state,id};
             runner.update(con, sql, params);
  	   }catch(Exception e){
          	 throw new RuntimeException(e);
          	}
       }
}
