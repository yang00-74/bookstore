package service;

import java.util.List;

import domain.Book;
import domain.Cart;
import domain.Category;
import domain.Order;
import domain.PageBean;
import domain.QueryInfo;
import domain.User;

public interface BusinessService {

	/****************
	 * 分类相关
	 *****************/
	void addCategory(Category c);

	Category findCategory(String id);

	List getAllCategory();

	/**********
	 * 图书相关
	 ******************/
	public List getAllBook();
	
	void addBook(Book book);

	Book findBook(String id);

	PageBean bookPageQuery(QueryInfo info);

	/**************************
	 * 用户相关
	 **************************/
	void addUser(User user);

	User findUser(String username, String password);

	User findUser(String id);

	/*****************************
	 * 订单相关
	 ****************************/
	//用用户的购物车和用户产生订单
	void saveOrder(Cart cart, User user);

	Order findOrder(String id);

	List getOrderByState(boolean state);
	public void updatOrder(String id,boolean state);

}