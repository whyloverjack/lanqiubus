/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_dao
// @package: com.jack.lanqiubus.dao.lanqiubus_dao
// @className: TestSysMenuDAO
//
// @author: zhangyunjie
// @date： 2014-3-12
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.dao.lanqiubus_dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jack.lanqiubus.dao.admin.sys.impl.SysMenuDAO;
import com.jack.lanqiubus.model.admin.SysMenuModel;

/**
 * @description: TODO
 * 
 */
public class TestSysMenuDAO {
	
	@Test
	public void testGetMenu(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SysMenuDAO dao = (SysMenuDAO) beanFactory.getBean("sysMenuDAO");  
		
		List<SysMenuModel> list = dao.getSysMenu(1,2);
		for(SysMenuModel model : list){
			System.out.println(model.getName());
		}
	}
}
