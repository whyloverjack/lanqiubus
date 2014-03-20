/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_admin
// @package: com.jack.lanqiubus.admin.controller
// @className: FrameworkController
//
// @author: zhangyunjie
// @date： 2014-3-14
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jack.lanqiubus.biz.admin.sys.SysMenuBiz;
import com.jack.lanqiubus.model.admin.SysMenuModel;

/**
 * @description: 系统加载
 * 
 */
@Controller
@RequestMapping(value="/admin/")
public class FrameworkController {
	@Autowired
	private SysMenuBiz menuBiz = null;

	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors) throws Exception{
		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}
	
	@RequestMapping(value="framework",method=RequestMethod.GET)
	public ModelAndView getSysMenu(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mv = new ModelAndView("index");
		if(null != menuBiz){
			List<SysMenuModel> list = menuBiz.getSysMenuList();
			mv.addObject("MenuList", list);
		}
		return mv;
	}
	
	public void setMenuBiz(SysMenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}
}
