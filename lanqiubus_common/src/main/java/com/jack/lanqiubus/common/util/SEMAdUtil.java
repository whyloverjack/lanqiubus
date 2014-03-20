/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  ci-common
// @package: com.pzoom.ads.platform.backend.ci.common.util
// @className: SEMAdUtil
//
// @author: zhangyunjie
// @date： 2013-10-22
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.common.util;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @description: 处理SEM广告工具类
 * 
 */
public class SEMAdUtil {
	/**
     * 取得飘红词
     *
     * @param hdes
     * @return
     */
    public static List<String> getRedKeyword(String... hdes) {
        List<String> resultList = Lists.newArrayList();
        for (String str : hdes) {
            String[] spliterF = str.split("\\{");
            for (String strF : spliterF) {
                if (strF.contains("}")) {
                    String[] spliterL = strF.split("\\}");
                    resultList.add(spliterL[0]);
                }
            }
        }
        return resultList;
    }
}
