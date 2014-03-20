/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_dao
// @package: com.jack.lanqiubus.dao.admin.sys
// @className: ISysMenuDAO
//
// @author: zhangyunjie
// @date： 2014-3-19
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.dao.admin.sys;

import java.util.List;

import com.jack.lanqiubus.model.admin.SysMenuModel;

/**
 * @description: 系统菜单接口
 * 
 */
public interface ISysMenuDAO {
	/**
	 * 获取系统菜单
	 * @param level
	 * @param type
	 * @return
	 */
	public List<SysMenuModel> getSysMenu(int level,int type);
}
