package com.hhxk.assessment.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable {
	private static final long serialVersionUID = -7759277457118758520L;
	
	private int pageSize; // 每页的记录数
	private long start; // 当前页第一条数据在List中的位置,从0开始
	private List data; // 当前页中存放的记录,类型一般为List
	private long totalCount; // 总记录数

	public Page() {
		this(0, 0, 20, new ArrayList());
	}

	public Page(long start, long totalSize, int pageSize, List data) {
		this.pageSize = pageSize;
		this.start = start;
		this.setTotalCount(totalSize);
		this.setData(data);
	}

	public long getTotalPageCount() {
		if (getTotalCount() % pageSize == 0)
			return getTotalCount() / pageSize;
		else
			return getTotalCount() / pageSize + 1;
	}

	public long getCurrentPageNo() {
		return start / pageSize + 1;
	}

	public boolean isHasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}

	public boolean isHasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	public int getStartOfPage(int pageNo) {
		return Page.getStartOfPage(pageNo, this.pageSize);
	}
	
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
}
