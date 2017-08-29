package com.warframe.po;

import java.util.List;

/**
 * 分页的数据单元
 * @author warframe
 *
 */

public class Page<T>{
	private int pageNow;//当前页面
	private int totalPage;//总的页数
	private int pageSize;//每页记录数
	private int recordSize;//总记录数
	
	//获取该Page对象符合要求的信息
	//select * from t_customer limit startPost,pageSize
	private List<T> list;
	
	@SuppressWarnings("unused")
	private int startPos;//读取记录开始的位置
	
	
	@SuppressWarnings("unused")
	private boolean hasFirst;//是否是首页
	@SuppressWarnings("unused")
	private boolean hasPre;//是否有前一页
	@SuppressWarnings("unused")
	private boolean hasLast;//是否是最后一页
	@SuppressWarnings("unused")
	private boolean hasNext;//是否有下一页
	
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	//是否是首页
	public boolean isHasFirst() {
		return (pageNow==1) ? true : false;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	//是否有前一页
	public boolean isHasPre() {
		//如果是首页，那么就没有前一页
		return isHasFirst() ? false : true;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	//是否是尾页
	public boolean isHasLast() {
		return (pageNow==totalPage) ? true : false;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	//是否有下一页
	//如果是尾页就没有下一页
	public boolean isHasNext() {
		return isHasLast() ? false : true;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	//读取记录开始的位置(对于mysql而言)
	public int getStartPos() {
		
		
		return (pageNow-1)*pageSize;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	
	
	
	//通过构造函数传入总记录数(recordSiz)和当前页数(pageCode)
	public Page(int recordSize,int pageNow){
		this.recordSize = recordSize;
		this.pageNow = pageNow;
	}
	//以及当前分页所要存放的实体信息
	private List<T> lists;

	
	//计算出总页数:总页数 = 总记录数/每页记录数
	public int getTotalPage() {
		return (recordSize%pageSize)==0 ? recordSize/pageSize : recordSize/pageSize+1;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(int recordSize) {
		this.recordSize = recordSize;
	}

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	
	
	

}
