package com.warframe.serviceimpl;

import java.util.List;

import javax.annotation.Resource;



import com.warframe.mapper.CustomerMapper;
import com.warframe.po.Customer;
import com.warframe.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	/**
	 * @Resource和@AutoWired的区别：
	 * 	@AutoWired默认byName注入
	 * 而@Resource默认byType注入找不到再按照name注入
	 */
	@Resource
	private CustomerMapper customerMapper;
	
	
	@Override
	public List<Customer> findAll() {
		return customerMapper.findAll();
	}


	@Override
	public void deleteById(String cid) {
		customerMapper.deleteById(cid);
	}


	@Override
	public Customer selectById(String cid) {
		return customerMapper.selectById(cid);
	}


	@Override
	public void update(Customer customer) {
		customerMapper.update(customer);
		
	}


	@Override
	public void save(Customer customer) {
		customerMapper.save(customer);
		
	}


	@Override
	public void batchDeleteCustomers(int[] cids) {
		customerMapper.batchDeleteCustomers(cids);
	}


	@Override
	public int count() {
		return customerMapper.count();
	}


	@Override
	public List<Customer> findByPage(int startPos, int pageSize) {
		return customerMapper.findByPage(startPos, pageSize);
	}

}
