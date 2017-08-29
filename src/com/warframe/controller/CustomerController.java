package com.warframe.controller;



import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.warframe.po.Customer;
import com.warframe.po.Page;
import com.warframe.service.CustomerService;
import com.warframe.utils.EncodingUtils;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Resource
	private CustomerService customerService;
	
	//分页显示信息
	@RequestMapping("/listCustomerByPage")
	public ModelAndView listCustomerByPage(HttpServletRequest request){
		ModelAndView maView = new ModelAndView();
		
		String value = request.getParameter("pageNow");
		if(null==value || value.trim().isEmpty()){
			value = "1";
		}
		int pageNow = Integer.valueOf(value);
		int recordSize = customerService.count();
	
		Page<Customer> page = new Page<>(recordSize, pageNow);
		page.setPageSize(10);
		page.setList(customerService.findByPage(page.getStartPos(), page.getPageSize()));
		
		maView.addObject("page", page);
		maView.setViewName("listCustomer2");
		return maView;
	}
	
	
	
//	//显示所有客户信息过时
//	@RequestMapping("/listCustomer.do")
//	public ModelAndView listCustomer(){
//		ModelAndView maView = new ModelAndView();
//		
//		//业务逻辑代码
//		List<Customer> customerList = customerService.findAll();
//		maView.addObject("customerList", customerList);
//		maView.setViewName("listCustomer");
//		
//		return maView;
//	}
	
	//删除客户
	@RequestMapping("/deleteCustomer.do")
	public ModelAndView deleteCustomer(HttpServletRequest request){
		ModelAndView maView = new ModelAndView();
		
		String cid = request.getParameter("cid");
		customerService.deleteById(cid);
		String value = request.getParameter("pageNow");
		if(null==value || value.trim().isEmpty()){
			value = "1";
		}
		int pageNow = Integer.valueOf(value);
		int recordSize = customerService.count();
	
		Page<Customer> page = new Page<>(recordSize, pageNow);
		page.setPageSize(10);
		page.setList(customerService.findByPage(page.getStartPos(), page.getPageSize()));
		
		maView.addObject("page", page);
		maView.setViewName("listCustomer2");
		return maView;
	}
	
	
	//将要更新的客户信息转发到更新页面
	@RequestMapping("/preUpdate.do")
	public ModelAndView preUpdate(HttpServletRequest request){
		String cid = request.getParameter("cid");
		
		Customer c = customerService.selectById(cid);
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customer",c);
		mav.setViewName("edit");
		
		return mav;
	}
	
	//对更新的客户进行更新并转发到listCustomer页面
	@RequestMapping("/updateCustomer.do")
	public ModelAndView updateCustomer(HttpServletRequest request){
		Customer c = new Customer();
		Map<String, String[]> customerInfo;
		try {
			customerInfo = EncodingUtils.codeHandle(request.getParameterMap());
			BeanUtils.populate(c, customerInfo);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		customerService.update(c);
		
		ModelAndView maView = new ModelAndView();
		String value = request.getParameter("pageNow");
		if(null==value || value.trim().isEmpty()){
			value = "1";
		}
		int pageNow = Integer.valueOf(value);
		int recordSize = customerService.count();
	
		Page<Customer> page = new Page<>(recordSize, pageNow);
		page.setPageSize(10);
		page.setList(customerService.findByPage(page.getStartPos(), page.getPageSize()));
		
		maView.addObject("page", page);
		
		maView.setViewName("listCustomer2");
		return maView;
	}
	
	//当点击添加时就跳转到add.jsp页面进行具体的操作
	@RequestMapping("/save")
	public String save(){
		return "add";
	}
	
	//添加客户并跳转到listCustomer页面
	@RequestMapping("/saveCustomer.do")
	public ModelAndView saveCustomer(HttpServletRequest request){
		Customer customer = new Customer();
		try {
			Map<String, String[]> customerProps = EncodingUtils.codeHandle(request.getParameterMap());
			BeanUtils.populate(customer, customerProps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		customerService.save(customer);
		
		
		ModelAndView maView = new ModelAndView();
		String value = request.getParameter("pageNow");
		if(null==value || value.trim().isEmpty()){
			value = "1";
		}
		int pageNow = Integer.valueOf(value);
		int recordSize = customerService.count();
	
		Page<Customer> page = new Page<>(recordSize, pageNow);
		page.setPageSize(10);
		page.setList(customerService.findByPage(page.getStartPos(), page.getPageSize()));
		
		maView.addObject("page", page);
		maView.setViewName("listCustomer2");
		return maView;
	}
	
	//批量删除的实现??
	
	
}
