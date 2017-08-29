package com.warframe.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.warframe.po.Customer;
import com.warframe.service.CustomerService;

public class ServiceTest {

	
	@Test
	public void testFindAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-*.xml");
		
		
		CustomerService customerService = (CustomerService) context.getBean("customerService");
		
		List<Customer> customerList = customerService.findAll();
		
		for(int i = 0;i<15;i++){
			System.out.println(customerList.get(i));
		}
		
	}
	@Test
	public void testDelete(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-*.xml");
		CustomerService customerService = (CustomerService) context.getBean("customerService");
		
		customerService.deleteById("1031");
	}

}
