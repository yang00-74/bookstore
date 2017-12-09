package web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Book;

import service.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	 private BusinessService service=new BusinessServiceImpl();
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String method=request.getParameter("method");
	  if("forAddUI".equals(method)){
		  forAddUI(request,response);
	  }
	  if("add".equals(method)){
		  add(request,response);
	  }
	  if("listBook".equals(method)){
		  list(request,response);
	  }
	}

	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List list=service.getAllBook();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/listbook.jsp").forward(request, response);
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//放在绝对路径中不会丢失，放在web目录下服务器重启丢失
			//Book book=WebUtils.upload(request, this.getServletContext().getRealPath("/images"));
		
			Book book=WebUtils.upload(request, "C://apache-tomcat-7.0.79/webapps/BookStore/images");
			service.addBook(book);
			request.setAttribute("message", "添加成功");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}


	private void forAddUI(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List categories=service.getAllCategory();
		request.setAttribute("categories",categories);
		request.getRequestDispatcher("/manager/addbook.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
