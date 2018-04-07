package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * 
 * @author SL
 *
 */

@Controller
public class PageController {

	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String ShowIndex() {
		return "index";
	}
	
	
	/**
	 * 展示其他页面
	 * localhost:8080/item-add  ->跳转到item-add.jsp  路由原理？？
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		
		return page;
	}
}
