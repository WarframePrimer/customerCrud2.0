package com.warframe.service;

import java.util.List;

import com.warframe.po.Customer;



public interface CustomerService {
	
	public List<Customer> findByPage(int startPos,int pageSize);
	
	public List<Customer> findAll();
	
	public void deleteById(String cid);
	
	public Customer selectById(String cid);
	
	
	public void update(Customer customer);
	
	public void save(Customer customer);
	
	public void batchDeleteCustomers(int[] cids);
	
	public int count();
}
