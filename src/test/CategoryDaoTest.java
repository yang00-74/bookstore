package test;

import java.util.List;

import org.junit.Test;

import utils.JdbcUtils;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;

public class CategoryDaoTest {
	@Test
	public void testadd(){
        CategoryDao dao=new CategoryDaoImpl();
        Category c=new Category();
        c.setId("2");
        c.setName("’‹—ß");
        c.setDescription("≤ªø…√Ë ˆ");
        dao.add(c);
    	JdbcUtils.commitTranscation();
	}
	@Test
	public void testfind(){
		 CategoryDao dao=new CategoryDaoImpl();
		 Category c=dao.find("2");
		 JdbcUtils.commitTranscation();
		 System.out.println(c.getName()+c.getDescription());
	}
     
	@Test
	public void testgetAll(){
		
		 CategoryDao dao=new CategoryDaoImpl();
		 List list=dao.getAll();
		 JdbcUtils.commitTranscation();
		 System.out.println(list.size());
	}
        
}
