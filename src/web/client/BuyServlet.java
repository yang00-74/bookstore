package web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Book;
import domain.Cart;

import service.BusinessService;
import service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String id=request.getParameter("id");
	   BusinessService service=new BusinessServiceImpl();
	   Book book=service.findBook(id);
	   
	   Cart cart=(Cart) request.getSession().getAttribute("cart");
	   if(cart==null){
		   cart=new Cart();
		   request.getSession().setAttribute("cart", cart);
	   }
	   cart.add(book);
	   response.sendRedirect(request.getContextPath()+"/client/listcart.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
