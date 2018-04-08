package com.sl.controller;

import java.util.List;

import org.aspectj.weaver.ClassAnnotationValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sl.mapper.TbItemMapper;
import com.sl.pojo.TbItem;
import com.sl.pojo.TbItemExample;

public class PageHelperTest {

	@Test
	public void testPageHelper() {
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获取Mapper的代理对象
		TbItemMapper mapper= applicationContext.getBean(TbItemMapper.class);
		//执行查询,分页
		TbItemExample example = new TbItemExample();
		//分页
		PageHelper.startPage(1, 10);
		
		List<TbItem> list = mapper.selectByExample(example);
		
		//商品列表遍历
		for(TbItem tbItem : list)
		{
			System.out.println(tbItem.getTitle());
		}
		
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long totalCount = pageInfo.getTotal();
		
		System.out.println("共有商品："+totalCount);
		
		
	}
}
