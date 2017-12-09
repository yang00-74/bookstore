package dao;

import java.util.List;

import domain.Book;
import domain.QueryResult;

public interface BookDao {

	void add(Book b);

	Book find(String id);

	QueryResult pageQuery(int startindex, int pagesize, String where,
			Object param);
	public List getAll();
}