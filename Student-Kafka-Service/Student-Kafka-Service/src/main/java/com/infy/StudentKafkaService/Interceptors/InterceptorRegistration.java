package com.infy.StudentKafkaService.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SuppressWarnings("deprecation")
@Component
public class InterceptorRegistration extends WebMvcConfigurerAdapter
{
		@Autowired
		private InfyStudentInterceptor infyStudentInterceptor;
		
		@Override
		public void addInterceptors(InterceptorRegistry registry) 
		{
			registry.addInterceptor(infyStudentInterceptor);
		}
}
