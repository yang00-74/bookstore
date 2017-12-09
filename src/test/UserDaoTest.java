package test;

import org.junit.Test;

import utils.JdbcUtils;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;

public class UserDaoTest {
	UserDao dao=new UserDaoImpl();
        @Test
        public void testAdd(){
        	User u=new User();
        	
        	
        	u.setId("2");
        	u.setUsername("windy");
        	u.setPassword("123456");
        	u.setPhone("18254457895");
        	u.setAddress("ÄÏ¾©");
        	
        	dao.add(u);
        	JdbcUtils.commitTranscation();      	
        }
        @Test
        public void testFind(){
        	User u=dao.find("1");
        	System.out.println(u.getUsername());
        	JdbcUtils.commitTranscation();   
        }
        @Test
        public void testFindBy(){
        	User u=dao.find("white","123456");
        	System.out.println(u.getUsername()+":"+u.getAddress());
        	JdbcUtils.commitTranscation();   
        }
}
