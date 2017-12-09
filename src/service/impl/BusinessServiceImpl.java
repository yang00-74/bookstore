package service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import service.BusinessService;

import dao.BookDao;
import dao.CategoryDao;
import dao.OrderDao;
import dao.UserDao;
import domain.Book;
import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.Order;
import domain.OrderItem;
import domain.PageBean;
import domain.QueryInfo;
import domain.QueryResult;
import domain.User;
import factory.DaoFactory;

public class BusinessServiceImpl implements BusinessService {
      /**
       * ��WEB���ṩ����
       */
	
	private CategoryDao cdao=DaoFactory.getInstance().createDao(CategoryDao.class);
	private BookDao bdao=DaoFactory.getInstance().createDao(BookDao.class);
	private OrderDao odao=DaoFactory.getInstance().createDao(OrderDao.class);
	private UserDao udao=DaoFactory.getInstance().createDao(UserDao.class);
	
	/****************
	 * �������
	 *****************/
	public void addCategory(Category c){
		  cdao.add(c);
	}
	
	public Category findCategory(String id){
		return cdao.find(id);
	}
	
	public List getAllCategory(){
		return cdao.getAll();
	}
	
	
	/**********
	 * ͼ�����
	 ******************/
	public void addBook(Book book){
		bdao.add(book);
	}
	
	public Book findBook(String id){
		return bdao.find(id);
	}
	
	public PageBean bookPageQuery(QueryInfo info){
		//�Ѳ�ѯ�Ľ���Ͳ�ѯ��Ϣ���ϵ�PageBean��
		QueryResult result=bdao.pageQuery(info.getStartindex(), info.getPagesize(), info.getWhere(), info.getQueryvalue());
		
		PageBean bean=new PageBean();
		
		bean.setCurrentpage(info.getCurrentpage());
		
		bean.setList(result.getList());
		
		bean.setPagesize(info.getPagesize());
		
		bean.setTotalrecord(result.getTotalrecord());
		
		return bean;
		
	}
	public List getAllBook(){
		return bdao.getAll();
	}
	
	/**************************
	 * �û����
	 **************************/
	public void addUser(User user){
		udao.add(user);
	}
	
	public User findUser(String username,String password){
		return udao.find(username, password);
	}
	public User findUser(String id){
		return udao.find(id);
	}
	
	
	/*****************************
	 * �������
	 ****************************/
	//���û��Ĺ��ﳵ���û���������
	public void saveOrder(Cart cart,User user){
		
		Order order=new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		
		//�ù��ﳵ�еĹ��������ɶ�����
		//���弯�ϱ��涩����
		Set oitems=new HashSet();
		
		Set<Map.Entry<String , CartItem>> set=cart.getMap().entrySet();
		for(Map.Entry<String , CartItem> entry:set){
			CartItem citem=entry.getValue();//�õ�ÿһ��������
			OrderItem oitem=new OrderItem();
			
			oitem.setBook(citem.getBook());
			oitem.setId(UUID.randomUUID().toString());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			
			oitems.add(oitem);
		}
		order.setOrderitems(oitems);
		odao.add(order);
	}
	
	public Order findOrder(String id){
		return odao.find(id);
	}
	public List getOrderByState(boolean state){
		return odao.getAll(state);
	}
	public void updatOrder(String id,boolean state){
		odao.update(id, state);
	}
}
