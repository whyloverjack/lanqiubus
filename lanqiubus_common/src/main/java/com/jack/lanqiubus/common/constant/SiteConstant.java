/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_common
// @package: com.jack.lanqiubus.common.constant
// @className: SiteConstant
//
// @author: zhangyunjie
// @date： 2014-3-6
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.common.constant;

import com.jack.lanqiubus.common.util.ConfigManager;

/**
 * @description: 网站级常量
 * 
 */
public class SiteConstant {
	private static final String SITE_TITLE = "";
	private static final String SITE_ROOTDIR = "lanqiubus";
	public static ConfigManager configManager = null;
	static{
		configManager = ConfigManager.getInstance("commons.properties");
	}
}
