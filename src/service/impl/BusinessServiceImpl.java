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
       * 对WEB层提供服务
       */
	
	private CategoryDao cdao=DaoFactory.getInstance().createDao(CategoryDao.class);
	private BookDao bdao=DaoFactory.getInstance().createDao(BookDao.class);
	private OrderDao odao=DaoFactory.getInstance().createDao(OrderDao.class);
	private UserDao udao=DaoFactory.getInstance().createDao(UserDao.class);
	
	/****************
	 * 分类相关
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
	 * 图书相关
	 ******************/
	public void addBook(Book book){
		bdao.add(book);
	}
	
	public Book findBook(String id){
		return bdao.find(id);
	}
	
	public PageBean bookPageQuery(QueryInfo info){
		//把查询的结果和查询信息整合到PageBean中
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
	 * 用户相关
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
	 * 订单相关
	 ****************************/
	//用用户的购物车和用户产生订单
	public void saveOrder(Cart cart,User user){
		
		Order order=new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		
		//用购物车中的购物项生成订单项
		//定义集合保存订单项
		Set oitems=new HashSet();
		
		Set<Map.Entry<String , CartItem>> set=cart.getMap().entrySet();
		for(Map.Entry<String , CartItem> entry:set){
			CartItem citem=entry.getValue();//得到每一个购物项
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
