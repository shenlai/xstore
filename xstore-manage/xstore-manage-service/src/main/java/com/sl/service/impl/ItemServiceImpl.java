package com.sl.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sl.common.pojo.DataGridResult;
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

	@Override
	public DataGridResult getItemList(int page, int rows) {
		
		TbItemExample example =new TbItemExample();
		
		PageHelper.startPage(page, rows);
		
	  	List<TbItem> list = itemMapper.selectByExample(example);
	  	
	  	//创建返回对象
	  	DataGridResult result = new DataGridResult();
	  	result.setRows(list);
	  	//取总条数
	  	PageInfo<TbItem> pageInfo = new PageInfo<>(list);
	  	result.setTotal(pageInfo.getTotal());
	  	
	  	return result;
	  	
	}

}



































