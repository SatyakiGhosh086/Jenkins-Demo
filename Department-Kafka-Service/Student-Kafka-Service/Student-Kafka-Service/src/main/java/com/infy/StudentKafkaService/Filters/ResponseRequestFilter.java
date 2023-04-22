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

@Configuration
public class ResponseRequestFilter implements Filter 
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Inside the Response Request Filter");
        System.out.println("Logging Request :\n"+req.getMethod()+"\n"+req.getRequestURI());
        chain.doFilter(request, response);
        System.out.println("Logging Response : "+res.getContentType());
		
	}
	
	@Bean//This is our own configured filter
	public FilterRegistrationBean<ResponseRequestFilter> loggingFilterOne(){
	    FilterRegistrationBean<ResponseRequestFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new ResponseRequestFilter());
	    registrationBean.addUrlPatterns("/infyStudent/*");
	    registrationBean.setOrder(1);
	        
	    return registrationBean;    
	}
	
}
