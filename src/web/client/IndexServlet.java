package web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PageBean;
import domain.QueryInfo;

import service.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

/**
 * 获取首页书籍显示
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BusinessService service=new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QueryInfo info=WebUtils.request2Bean(request, QueryInfo.class);
		
		String category_id=request.getParameter("category_id");
		if(category_id!=null && !category_id.trim().equals("")){
			info.setQueryname("category_id");
			info.setQueryvalue(category_id);
		}
		
		List categories=service.getAllCategory();
		PageBean bean=service.bookPageQuery(info);
		
		request.setAttribute("categories", categories);
		request.setAttribute("pagebean", bean);
		
		request.getRequestDispatcher("/client/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
