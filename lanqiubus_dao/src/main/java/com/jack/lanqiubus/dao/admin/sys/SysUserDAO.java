/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_dao
// @package: com.jack.lanqiubus.dao.admin.sys
// @className: SysUserDAO
//
// @author: zhangyunjie
// @date： 2014年3月10日
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.dao.admin.sys;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jack.lanqiubus.common.constant.TableConstant;

/**
 * @description: 系统管理员处理类
 * 
 */
public class SysUserDAO {

	private JdbcTemplate jdbcTemplate = null;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/**
	 * 根据用户名和密码进行管理帐户信息验证，返回是否可以进行正常登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 */
	public boolean checkUser(String userName,String password){
		String sql = "select count(1) from " + TableConstant.T_SYS_USER + " where username=? and password=? and is_lock=? and `status`=?";
		Object[] args = {userName,password,0,1};
		
		return jdbcTemplate.queryForObject(sql, args, Integer.class) > 0 ? true : false;
	}
	
	
}
