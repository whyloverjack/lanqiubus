/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  ci-common
// @package: com.pzoom.ads.platform.backend.ci.common.util
// @className: MD5Util
//
// @author: zhangyunjie
// @date： 2013-10-23
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: MD5加密算法类
 * 
 */
public class MD5Util {
	/**
	 * MD5字符串加密
	 * 
	 * @param resource
	 *            源字符串
	 * @return <tt>String</tt> 加密后的MD5字符串
	 */
	public static String md5Encryption(String resource) {
		if (resource == null) {
			resource = "null";
		}
		String str = null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(resource.getBytes("UTF-8"));
			byte b[] = md.digest();
			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位的加密
			// str = buf.toString();

			// 16位的加密
			str = buf.toString().substring(8, 24);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * MD5字符串加密
	 * 
	 * @param resource
	 *            源字符串
	 * @return <tt>String</tt> 加密后的MD5字符串
	 */
	public static String md5Encryption(String[] resource) {
		if (null == resource || resource.length < 1) {
			return null;
		}

		String allMD5 = "";
		for (String tempStr : resource) {
			allMD5 = allMD5 + md5Encryption(tempStr);
		}
		return allMD5;
	}

}
