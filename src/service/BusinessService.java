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
	 * �������
	 *****************/
	void addCategory(Category c);

	Category findCategory(String id);

	List getAllCategory();

	/**********
	 * ͼ�����
	 ******************/
	public List getAllBook();
	
	void addBook(Book book);

	Book findBook(String id);

	PageBean bookPageQuery(QueryInfo info);

	/**************************
	 * �û����
	 **************************/
	void addUser(User user);

	User findUser(String username, String password);

	User findUser(String id);

	/*****************************
	 * �������
	 ****************************/
	//���û��Ĺ��ﳵ���û���������
	void saveOrder(Cart cart, User user);

	Order findOrder(String id);

	List getOrderByState(boolean state);
	public void updatOrder(String id,boolean state);

}