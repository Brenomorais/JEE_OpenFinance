package com.buildsoftware.cursojsf2.financeiro.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(servletNames={"Faces Servlet"})
public class HibernateSessionFilter implements Filter{


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//Implementando o pattern open session view
		System.out.println(">>sessao open");
		Session session = HibernateUtil.getSession();
		Transaction trx = null;
		
		try{
			trx = session.beginTransaction();
			System.out.println(">>inicio trx.");
			request.setAttribute("session", session);			
			chain.doFilter(request, response);			
			trx.commit();
			System.out.println(">>fim trx");
		}catch(Exception e){
			if(trx != null){
				trx.rollback();
				System.out.println(">>roolback trx");
			}
		} finally{
			session.close();
			System.out.println(">>sessao close");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
