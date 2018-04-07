package com.sl.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sl.mapper.TbItemMapper;
import com.sl.pojo.TbItemExample.Criteria;
import com.sl.pojo.TbItem;
import com.sl.pojo.TbItemExample;
import com.sl.service.ItemService;

/**
 * 商品管理Service
 * @author SL
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem geTbItemById(long itemId) {
		
	//TbItem item=	itemMapper.selectByPrimaryKey(itemId);
	TbItemExample example = new TbItemExample();
	//查询条件
	Criteria criteria = example.createCriteria();
	criteria.andIdEqualTo(itemId);
	
	List<TbItem> list = itemMapper.selectByExample(example);
	
	if(list!=null && list.size()>0) {
		TbItem item = list.get(0);
		return item;
	}
	
	return null;
	
		
	}

}



































