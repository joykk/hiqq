package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName="Servlet3Filter",urlPatterns={"/IndexAction.action","/index.jsp","/SerchAcation.action","/addStudent.jsp","/explain.jsp"})
public class IndexFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest Request, ServletResponse Response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) Request;
		HttpServletResponse hres = (HttpServletResponse) Response;

		if(null==hreq.getSession().getAttribute("passkey"))
		{
			hres.sendRedirect(hreq.getContextPath()+"/keypass.jsp");
		}else{
			chain.doFilter(Request, Response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
