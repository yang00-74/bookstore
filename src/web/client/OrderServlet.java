package web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusinessService;
import service.impl.BusinessServiceImpl;

import domain.Cart;
import domain.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			  request.setAttribute("message", "ÇëÏÈµÇÂ¼£¡£¡<meta http-equiv='refresh' content='2;url="+request.getContextPath()+"/index.jsp'>");
			  request.getRequestDispatcher("/message.jsp").forward(request, response);
			  return;
		}
		try{
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		
		BusinessService service=new BusinessServiceImpl();
		service.saveOrder(cart, user);
		request.setAttribute("message", "ÒÑÈ·ÈÏ¶©µ¥ <meta http-equiv='refresh' content='2;url="+request.getContextPath()+"/index.jsp'>");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "¶©µ¥Ê§°Ü <meta http-equiv='refresh' content='2;url="+request.getContextPath()+"/index.jsp'>");
			
		}	
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
