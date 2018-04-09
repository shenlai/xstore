package com.sl.service;

import java.util.List;

import com.sl.common.pojo.EUTreeNode;

public interface ItemCatService {
	

	 List<EUTreeNode> getCatList(long parentId) ;
}
