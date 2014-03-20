/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_dao
// @package: com.jack.lanqiubus.dao.admin.sys
// @className: SysMenuDAO
//
// @author: zhangyunjie
// @date： 2014-3-11
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.dao.admin.sys.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.jack.lanqiubus.common.constant.TableConstant;
import com.jack.lanqiubus.dao.admin.sys.ISysMenuDAO;
import com.jack.lanqiubus.model.admin.SysMenuModel;

/**
 * @description: 系统后台菜单管理
 * 
 */
public class SysMenuDAO extends JdbcDaoSupport implements ISysMenuDAO {
	
	/**
	 * 获取系统菜单
	 * @param level
	 * @param type
	 * @return
	 */
	public List<SysMenuModel> getSysMenu(int level,int type){
		String sql = "select id,pid,ord,name,module,controller,action,isshow,type from "+TableConstant.T_SYS_MENU+" where type=? ";
		if(level==1){
			sql += " and pid=0";
		}else{
			sql += " and pid<>0";
		}
//		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<SysMenuModel> menuList = getJdbcTemplate().query(sql, new Object[]{type}, new SysMenuRowMapper());
//		List<SysMenuModel> menuLevelList = Lists.newArrayList();
//		getSysMenu(menuLevelList,menuList.get(0),menuList.subList(1, menuList.size()));
		return menuList;
	}
	
	class SysMenuRowMapper implements RowMapper<SysMenuModel>{

		@Override
		public SysMenuModel mapRow(ResultSet rs, int arg1) throws SQLException {
			SysMenuModel model = new SysMenuModel();
			model.setId(rs.getInt("id"));
			model.setPid(rs.getInt("pid"));
			model.setOrd(rs.getInt("ord"));
			model.setName(rs.getString("name"));
			model.setModule(rs.getString("module"));
			model.setController(rs.getString("controller"));
			model.setAction(rs.getString("action"));
			model.setIsshow(rs.getBoolean("isshow"));
			model.setType(rs.getInt("type"));
			model.setChildMenu(new ArrayList<SysMenuModel>());
			return model;
		}
		
	}
}
