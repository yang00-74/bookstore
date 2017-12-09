package web.client;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

import service.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try{      
		User user=WebUtils.request2Bean(request, User.class);
	      user.setId(UUID.randomUUID().toString());
	      
	      BusinessService service=new BusinessServiceImpl();
	      service.addUser(user);
	      request.setAttribute("message", "×¢²á³É¹¦<meta http-equiv='refresh' content='2;url="+request.getContextPath()+"/index.jsp'>");
	    }catch(Exception e){
	    	e.printStackTrace();
	    	request.setAttribute("message", "×¢²áÊ§°Ü");
	    }
	     request.getRequestDispatcher("/message.jsp").forward(request, response);
	 }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
