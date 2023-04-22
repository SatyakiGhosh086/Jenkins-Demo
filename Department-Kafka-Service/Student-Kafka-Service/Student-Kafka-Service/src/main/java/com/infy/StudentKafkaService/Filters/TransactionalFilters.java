package com.infy.StudentKafkaService.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(2)
@Configuration
public class TransactionalFilters implements Filter
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Inside the Transactional Filter");
        System.out.println("Logging Request :\n"+req.getMethod()+"\n"+req.getRequestURI());
        chain.doFilter(request, response);
        System.out.println("Logging Response : "+res.getContentType());
		
	}
	
	@Bean
	public FilterRegistrationBean<TransactionalFilters> loggingFilterTwo(){
	    FilterRegistrationBean<TransactionalFilters> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new TransactionalFilters());
	    registrationBean.addUrlPatterns("/infyStudent/*");//this will apply on filters as well. But this is our customization in filters
	    registrationBean.setOrder(2);
	        
	    return registrationBean;    
	}
	
	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException 
//	{
//		HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        System.out.println("Inside the Transaction Filter");
//        System.out.println("Logging Request :\n"+req.getMethod()+"\n"+req.getRequestURI());
//        chain.doFilter(request, response);
//        System.out.println("Logging Response : "+res.getContentType());
//		
//	} the commented code for filtering all the requests.
	
	
	
}
