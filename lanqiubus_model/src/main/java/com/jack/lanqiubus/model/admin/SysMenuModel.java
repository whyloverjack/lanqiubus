/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_model
// @package: com.jack.lanqiubus.model.admin
// @className: SysMenuModel
//
// @author: zhangyunjie
// @date： 2014-3-11
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.model.admin;

import java.util.List;

/**
 * @description: 系统菜单
 * 
 */
public class SysMenuModel {
	private int id;
	private int pid;
	private int ord;
	private String name;
	private String module;
	private String controller;
	private String action;
	private boolean isshow;
	private int type;
	private List<SysMenuModel> childMenu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getOrd() {
		return ord;
	}
	public void setOrd(int ord) {
		this.ord = ord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public boolean isIsshow() {
		return isshow;
	}
	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<SysMenuModel> getChildMenu() {
		return childMenu;
	}
	public void setChildMenu(List<SysMenuModel> childMenu) {
		this.childMenu = childMenu;
	}
}
