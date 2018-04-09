package com.sl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.common.pojo.EUTreeNode;
import com.sl.mapper.TbItemCatMapper;
import com.sl.pojo.TbContentCategoryExample.Criteria;
import com.sl.pojo.TbItemCat;
import com.sl.pojo.TbItemCatExample;
import com.sl.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
	
		//创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		com.sl.pojo.TbItemCatExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		//根据条件查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		
		//把列表转换成treeNodelist
		for(TbItemCat tbItemCat:list)
		{
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
		}
		
		return resultList;
	}

	
	
}
