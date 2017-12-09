package dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.JdbcUtils;

import dao.BookDao;
import domain.Book;
import domain.QueryResult;
/**
 *添加了注释
 */
public class BookDaoImpl implements BookDao {
	
    public void add(Book b){
    	try{
       	 Connection con= JdbcUtils.getConnection();
       	 QueryRunner runner=new QueryRunner();
       	 String sql="insert into book(id,name,price,author,image,description,category_id) values(?,?,?,?,?,?,?)";
       	 Object params[]={b.getId(),b.getName(),b.getPrice(),b.getAuthor(),b.getImage(),b.getDescription(),b.getCategory().getId()};
       	 runner.update(con, sql, params);     	 
       	}catch(Exception e){
       		e.printStackTrace();
       	}
    }
    public Book find(String id){
    	try{
          	 Connection con= JdbcUtils.getConnection();
          	 QueryRunner runner=new QueryRunner();
          	 String sql="select * from book where id=?";
          	  return (Book)runner.query(con, sql, id,new BeanHandler(Book.class));     	 
          	}catch(Exception e){
          	 throw new RuntimeException(e);
          	}
    }
   
    /**
     * 用户带where过来，则返回分类下的分页数
     * 否则返回所有分页数
     * String where="where category id=?" 
     */
    private List<Book> getPageDate(int startindex,int pagesize ,String where,Object param){
    	try{
	       	 Connection con= JdbcUtils.getConnection();
	       	 QueryRunner runner=new QueryRunner();
	       	 if(where==null||where.trim().equals("")){
	       		 //返回所有分页数
	       		 String sql="select * from book limit ?,?";
	       		 Object params[]={startindex,pagesize};
	       		 return (List<Book>)runner.query(con, sql, params, new BeanListHandler(Book.class));
	       	 }else{//返回分类分页数
	       		 String sql="select * from book "+ where +" limit ?,?";
	       		 Object params[]={param,startindex,pagesize};
	       		 return (List<Book>)runner.query(con, sql, params, new BeanListHandler(Book.class));		       	 
	       	 } 	       	 
	       	}catch(Exception e){
	       		throw new RuntimeException(e);
	       	}
    }
    
    private int getPageTotalRecord(String where,Object param){
    	try{
	       	 Connection con= JdbcUtils.getConnection();
	       	 QueryRunner runner=new QueryRunner();
	       	 if(where==null||where.trim().equals("")){
	       		 //返回所有书籍数量
	       		String sql="select count(*) from book";
	       		return ((Long)runner.query(con, sql, new ScalarHandler())).intValue();
	       	 }else{
	       		 //返回分类书籍数量
	       		String sql="select count(*) from book "+ where;
	       		return ((Long)runner.query(con, sql,param, new ScalarHandler())).intValue();       	 
	       	 } 	       	 
	       	}catch(Exception e){
	       		throw new RuntimeException(e);
	       	}
    }
    
    public QueryResult pageQuery(int startindex,int pagesize ,String where,Object param){
    	List list=getPageDate(startindex, pagesize, where, param);
    	int totalrecord=getPageTotalRecord(where, param);
    	
    	QueryResult result=new QueryResult();
    	result.setList(list);
    	result.setTotalrecord(totalrecord);
    	return result;
    }
    public List getAll(){
    	try{
         	 Connection con= JdbcUtils.getConnection();
         	 QueryRunner runner=new QueryRunner();
         	 String sql="select * from book";
         	  return (List)runner.query(con, sql,new BeanListHandler(Book.class));     	 
         	}catch(Exception e){
         	 throw new RuntimeException(e);
         	}
    }
}
