/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_biz
// @package: com.jack.lanqiubus.biz.admin.sys
// @className: SysMenuBiz
//
// @author: zhangyunjie
// @date： 2014-3-14
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.biz.admin.sys;

import java.util.List;

import com.google.common.collect.Lists;
import com.jack.lanqiubus.dao.admin.sys.impl.SysMenuDAO;
import com.jack.lanqiubus.model.admin.SysMenuModel;

/**
 * @description: 
 * 
 */
public class SysMenuBiz {
	private SysMenuDAO menuDao = null;

	public List<SysMenuModel> getSysMenuList(){
		List<SysMenuModel> menuList = Lists.newArrayList();
		List<SysMenuModel> parentMenuList = menuDao.getSysMenu(1, 2);
		List<SysMenuModel> childMenuList = menuDao.getSysMenu(2, 2);
		for(SysMenuModel parentModel : parentMenuList){
			for(SysMenuModel childMenuModel : childMenuList){
				if(parentModel.getId() == childMenuModel.getPid()){
					parentModel.getChildMenu().add(childMenuModel);
				}
			}
			menuList.add(parentModel);
		}
		return menuList;
	}
	
	public void setMenuDao(SysMenuDAO menuDao) {
		this.menuDao = menuDao;
	}

	public SysMenuDAO getMenuDao() {
		return menuDao;
	} 
}
