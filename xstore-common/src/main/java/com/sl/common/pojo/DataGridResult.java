package com.sl.common.pojo;

import java.util.List;

import org.apache.log4j.lf5.viewer.LogFactor5LoadingDialog;

public class DataGridResult {

	private long total;
	//? 任意类型
	private List<?> rows;
	
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
