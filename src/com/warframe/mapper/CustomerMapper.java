package com.warframe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warframe.po.Customer;

public interface CustomerMapper {
	/**
	 * 查询符合条件的记录一共有几条
	 * @return
	 */
	public int count();
	
	/**
	 * 
	 * @param startPos 记录开始位置
	 * @param pageSize	要几条记录
	 * @return
	 */
	public List<Customer> findByPage(@Param("startPos")int startPos,@Param("pageSize")int pageSize);

	/**
	 * 查询所有客户信息 ps:后期实现分页
	 * @return
	 */
	public List<Customer> findAll();
	
	/**
	 * 增加删除功能
	 */
	public void deleteById(String cid);
	
	public Customer selectById(String cid);
	
	public void update(Customer customer);
	
	public void save(Customer customer);
	
	/**
	 * 批量删除的实现
	 */
	public void batchDeleteCustomers(int[] cids);
	
	
}
