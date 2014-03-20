/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_biz
// @package: com.jack.lanqiubus.biz.test
// @className: TestSysMenuBiz
//
// @author: zhangyunjie
// @date： 2014-3-14
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.biz.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.jack.lanqiubus.biz.admin.sys.SysMenuBiz;
import com.jack.lanqiubus.model.admin.SysMenuModel;

/**
 * @description: 
 * 
 */
public class TestSysMenuBiz {

	@Test
	public void testGetSysMenu(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SysMenuBiz dao = (SysMenuBiz) beanFactory.getBean("sysMenuBiz");  
		
		List<SysMenuModel> list = dao.getSysMenuList();
		Gson gson = new Gson();
		for(SysMenuModel model : list){
			System.out.println(gson.toJson(model));
		}
	}
}
