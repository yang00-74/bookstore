package test;

import java.util.List;

import org.junit.Test;

import service.impl.BusinessServiceImpl;
import utils.JdbcUtils;

import dao.impl.CategoryDaoImpl;
import domain.Book;
import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.Order;
import domain.PageBean;
import domain.QueryInfo;
import domain.User;

public class BusinessServiceTest {
	
	private BusinessServiceImpl se=new BusinessServiceImpl();
	
    @Test  
	public void testAddCatrgory(){
    	  Category c=new Category();
    	  c.setId("3");
    	  c.setName("神秘学");
    	  c.setDescription("不可描述");
         
    	  se.addCategory(c);
    	  
    	  JdbcUtils.commitTranscation();
    }
    @Test  
   	public void testFindCatrgory(){
       	  se.findCategory("3");
       	  
       	  JdbcUtils.commitTranscation();
       }
    @Test  
   	public void testGetAll(){
       	 List list=se.getAllCategory();
       	  
       	  JdbcUtils.commitTranscation();
       	  System.out.println(list.size());
       }
    @Test
    public void testAddBook(){
    	Book b=new Book();
    	Category c=new Category();
    	c.setId("2");
    	
    	b.setId("5");
    	b.setName("南海之谜");
    	b.setAuthor("mini");
    	b.setPrice(30);
    	b.setImage("ljkl");
    	b.setDescription("难以形容");
    	b.setCategory(c);
    	
    	se.addBook(b);
    	JdbcUtils.commitTranscation();
    }
    @Test
    public void testFindBook(){
          se.findBook("3")   ; 	
    }
    @Test
    public void testPageQuery(){
    	QueryInfo in=new QueryInfo();
    	in.setCurrentpage(1);
    	in.setPagesize(3);
//    	in.setQueryname("category_id");
//    	in.setQueryvalue("1");
    	
    	PageBean bean =se.bookPageQuery(in);
    	JdbcUtils.commitTranscation();
    	System.out.println(bean.getList());
    }
    @Test
    public void testAddUSer(){
    	User u=new User();
    	    	
    	u.setId("3");
    	u.setUsername("wind");
    	u.setPassword("123456");
    	u.setPhone("18254457895");
    	u.setAddress("南京");
    	se.addUser(u);
    }
    @Test
    public void testSaveOrder(){
    	User u=new User();
    	
    	u.setId("2");
    	u.setUsername("windy");
    	u.setPassword("123456");
    	u.setPhone("18254457895");
    	u.setAddress("南京");
    
        Cart cart=new Cart();
        CartItem c1=new CartItem();
     
        Book b=new Book();
    	Category c=new Category();
    	c.setId("2");
    	
    	b.setId("5");
    	b.setName("南海之谜");
    	b.setAuthor("mini");
    	b.setPrice(30);
    	b.setImage("ljkl");
    	b.setDescription("难以形容");
    	b.setCategory(c);
    	
    	c1.setBook(b);
    	cart.add(b);
    	
    	se.saveOrder(cart, u);
    	JdbcUtils.commitTranscation();
    }
    @Test
    public void testFindOrder(){
    	Order o=se.findOrder("7c50c417-cbf7-4589-81ab-c05e9df6fb55");
    }
}
