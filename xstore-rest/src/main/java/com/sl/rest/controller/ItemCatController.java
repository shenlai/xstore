package com.sl.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.common.utils.JsonUtils;
import com.sl.rest.pojo.CatResult;
import com.sl.rest.service.*;

@Controller
public class ItemCatController {
	@Autowired
    private ItemCatService itemCatService;
	
	@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		CatResult catResult =itemCatService.getItemCatList();
		
		String jsonStr = JsonUtils.objectToJson(catResult);
		
		
        String result = callback + "(" + jsonStr + ");";
        return result;	
	}

}
