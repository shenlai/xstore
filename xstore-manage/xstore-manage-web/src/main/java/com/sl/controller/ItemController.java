package com.sl.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.common.pojo.DataGridResult;
import com.sl.pojo.TbItem;
import com.sl.service.ItemService;


/**
 * 商品管理Controller
 * @author SL
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem geTbItemById(@PathVariable Long itemId)
	{
		TbItem tbItem = itemService.geTbItemById(itemId);
		
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getItemList(int page,int rows) {
		
		DataGridResult itemList = itemService.getItemList(page, rows);
		
		return itemList;
	}
}
