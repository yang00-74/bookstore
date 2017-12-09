package test;

import org.junit.Test;

import utils.JdbcUtils;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import domain.Book;
import domain.Category;
import domain.QueryResult;

public class BookDaoTest {
	@Test
    public void testadd(){
    	BookDao dao=new BookDaoImpl();
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
    	
    	dao.add(b);
    	JdbcUtils.commitTranscation();
    }
	@Test
	public void testFind(){
		BookDao dao=new BookDaoImpl();
		Book b=dao.find("1");
    	JdbcUtils.commitTranscation();
    	
    	System.out.println(b.getName());
	}
	@Test
	public void testQuery(){
		BookDao dao=new BookDaoImpl();
		
		QueryResult s=dao.pageQuery(0, 5, "where category_id=?", 2);
		
    	JdbcUtils.commitTranscation();
    	System.out.println(s.getList().size());//获得页上书数量
    	System.out.println(s.getTotalrecord());//获得该分类总数
    	
	}
}
