/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_core
// @package: com.jack.lanqiubus.core.jdbctemplate
// @className: BaseJdbcTemplate
//
// @author: zhangyunjie
// @date： 2014年3月10日
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.core.jdbctemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * @description: 系统操作SpringJDBC基类
 * 
 */
public class BaseJdbcTemplate {
	private SimpleJdbcTemplate jdbcTemplate = null;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	/**
	 * 获取JDBC连接处理器
	 * @return
	 */
	public SimpleJdbcTemplate getJdbcTemplate(){
		return this.jdbcTemplate;
	}
}
