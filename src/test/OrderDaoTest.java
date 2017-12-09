package test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import utils.JdbcUtils;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import domain.Book;
import domain.Category;
import domain.Order;
import domain.OrderItem;
import domain.User;

public class OrderDaoTest {
      OrderDao dao=new OrderDaoImpl();  
      
	@Test
       public void testAdd(){
    	Order o=new Order();
    	
    	User u=new User();
    	u.setId("2");
    	
    	OrderItem it=new OrderItem();
    	it.setId("1");
    	it.setPrice(24);
    	it.setQuantity(2);
    	
    	Book b=new Book();
    	Category c=new Category();
    	c.setId("1");
    	
    	b.setId("3");
    	b.setName("南华之谜");
    	b.setAuthor("mini");
    	b.setPrice(30);
    	b.setImage("ljkl");
    	b.setDescription("难以形容");
    	b.setCategory(c);
    	
    	it.setBook(b);
    	Set set=new HashSet();
    	set.add(it);
    	
    	o.setId("2");
    	o.setPrice(89);
    	o.setState(false);
    	o.setOrdertime(new Date("1997-12-12"));
    	o.setOrderitems(set);
    	
    	o.setUser(u);
    	
		dao.add(o);
		JdbcUtils.commitTranscation();
       }
	@Test
	public void findTest(){
		 Order o=dao.find("2");
		 System.out.println(o.getOrderitems().size());
	}
	@Test
	public void getAllTest(){
		 List list=dao.getAll(false);
		 System.out.println(list.size());
	}
}
