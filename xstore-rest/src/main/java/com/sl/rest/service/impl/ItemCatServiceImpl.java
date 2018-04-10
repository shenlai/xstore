package com.sl.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.mapper.TbItemCatMapper;
import com.sl.pojo.TbItemCat;
import com.sl.pojo.TbItemCatExample;
import com.sl.pojo.TbItemCatExample.Criteria;
import com.sl.rest.pojo.CatNode;
import com.sl.rest.pojo.CatResult;
import com.sl.rest.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCatList() {
		CatResult catResult = new CatResult();
		//查询分类列表
		catResult.setData(getCatList(0));
		
		return catResult;
	}
	
	private List<?> getCatList(long parentId){
		//查询条件
		TbItemCatExample example = new TbItemCatExample();

        Criteria criteria = example.createCriteria();
        
        criteria.andParentIdEqualTo(parentId);
        //执行
        List<TbItemCat> list =itemCatMapper.selectByExample(example);
        List resultList = new ArrayList<>();
        
        for(TbItemCat tbItemCat:list)
        {
        	//是否是父节点
        	if(tbItemCat.getIsParent()){
        		CatNode catNode =new CatNode();
        		if(parentId==0) {
        			 catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
        		}else {
        			catNode.setName(tbItemCat.getName());
        		}
        		 catNode.setUrl("/products/"+tbItemCat.getId()+".html");

                 catNode.setItem(getCatList(tbItemCat.getId()));
                 resultList.add(catNode);
        	}else {
        		//叶节点
        		 resultList.add("/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName());
        	}
        }
        
        return resultList;
	}

}
