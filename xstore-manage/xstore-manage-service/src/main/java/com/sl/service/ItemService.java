package com.sl.service;

import java.awt.List;

import com.sl.common.pojo.DataGridResult;
import com.sl.pojo.TbItem;

public interface ItemService {
	
	TbItem geTbItemById(long itemId);
	
	DataGridResult getItemList(int page,int rows);
}
