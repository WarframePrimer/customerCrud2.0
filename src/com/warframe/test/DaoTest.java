package com.warframe.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.warframe.mapper.CustomerMapper;
import com.warframe.po.Customer;



public class DaoTest {
	@Test
	public void testFindAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-dao.xml");
		
		
		CustomerMapper mapper = context.getBean(CustomerMapper.class);
		
		List<Customer> customerList = mapper.findAll();
		
		for(int i = 0;i<15;i++){
			System.out.println(customerList.get(i));
		}
		
	}
	
	@Test
	public void testDelete(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-dao.xml");
		CustomerMapper mapper = context.getBean(CustomerMapper.class);
		mapper.deleteById("1011");
	}
	@Test
	public void testSelectById(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-dao.xml");
		CustomerMapper mapper = context.getBean(CustomerMapper.class);
		Customer c = mapper.selectById("1001");
		System.out.println(c);
	}
	
	
	@Test
	public void testUpdate(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-dao.xml");
		CustomerMapper mapper = context.getBean(CustomerMapper.class);
		
		Customer c = new Customer();
		c.setCid("1001");
		c.setCname("姚嘉斌");
		c.setGender("未知");
		c.setBirthday("2589-8-25");
		c.setCellphone("123456789");
		c.setEmail("12346789@56.com");
		c.setDescription("未来已来");
		
		mapper.update(c);
	}
	
	@Test
	public void testCount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-dao.xml");
		CustomerMapper mapper = context.getBean(CustomerMapper.class);
		
		
		System.out.println(mapper.count());
	}
}
