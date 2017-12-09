package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import utils.JdbcUtils;

@WebFilter("/TransactionFilter")
public class TransactionFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try{
			//拦截后将绑定到线程的操作延迟到获取链接时
			
			chain.doFilter(request, response);
			
			//获取当前线程，提交事务，释放链接
			JdbcUtils.commitTranscation();
		}finally{
			JdbcUtils.closeCon();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
