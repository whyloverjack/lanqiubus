/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司  
// 版权所有。
//
// 工程名：PZoom_Common
// 所属包：package com.pzoom.common;
// 
// 文件名：HashAlgorithmHelper.java
//
// 创建时间：2012-8-15
//----------------------------------------------------------------*/
package com.jack.lanqiubus.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.CRC32;

/**
 * 算法处理工具类
 *
 * @version [PZoom-V2.0]
 * @author  zhangyunjie
 *
 * 修改标识：
 * 修改描述：
 * 
 */
public enum HashAlgorithmHelper {
	/**
	 * Native hash (String.hashCode()).
	 */
	NATIVE_HASH,
	/**
	 * CRC32_HASH as used by the perl API. This will be more consistent both
	 * across multiple API users as well as java versions, but is mostly likely
	 * significantly slower.
	 */
	CRC32_HASH,
	/**
	 * FNV hashes are designed to be fast while maintaining a low collision
	 * rate. The FNV speed allows one to quickly hash lots of data while
	 * maintaining a reasonable collision rate.
	 *
	 */
	FNV1_64_HASH,
	/**
	 * Variation of FNV.
	 */
	FNV1A_64_HASH,
	/**
	 * 32-bit FNV1.
	 */
	FNV1_32_HASH,
	/**
	 * 32-bit FNV1a.
	 */
	FNV1A_32_HASH,
	/**
	 * MD5-based hash algorithm used by ketama.
	 */
	KETAMA_HASH;

	private static final long FNV_64_INIT = 0xcbf29ce484222325L;
	private static final long FNV_64_PRIME = 0x100000001b3L;

	private static final long FNV_32_INIT = 2166136261L;
	private static final long FNV_32_PRIME = 16777619;

	/**
	 * Compute the hash for the given key.
	 * 
	 * @return a positive integer hash
	 */
	public long hash(final String k) {
		long rv = 0;
		switch (this) {
		case NATIVE_HASH:
			rv = k.hashCode();
			break;
		case CRC32_HASH:
			// return (crc32(shift) >> 16) & 0x7fff;
			CRC32 crc32 = new CRC32();
			crc32.update(KeyUtil.getKeyBytes(k));
			rv = (crc32.getValue() >> 16) & 0x7fff;
			break;
		case FNV1_64_HASH: {
			// Thanks to pierre@demartines.com for the pointer
			rv = FNV_64_INIT;
			int len = k.length();
			for (int i = 0; i < len; i++) {
				rv *= FNV_64_PRIME;
				rv ^= k.charAt(i);
			}
		}
			break;
		case FNV1A_64_HASH: {
			rv = FNV_64_INIT;
			int len = k.length();
			for (int i = 0; i < len; i++) {
				rv ^= k.charAt(i);
				rv *= FNV_64_PRIME;
			}
		}
			break;
		case FNV1_32_HASH: {
			rv = FNV_32_INIT;
			int len = k.length();
			for (int i = 0; i < len; i++) {
				rv *= FNV_32_PRIME;
				rv ^= k.charAt(i);
			}
		}
			break;
		case FNV1A_32_HASH: {
			rv = FNV_32_INIT;
			int len = k.length();
			for (int i = 0; i < len; i++) {
				rv ^= k.charAt(i);
				rv *= FNV_32_PRIME;
			}
		}
			break;
		case KETAMA_HASH:
			byte[] bKey = computeMd5(k);
			rv = ((long) (bKey[3] & 0xFF) << 24)
					| ((long) (bKey[2] & 0xFF) << 16)
					| ((long) (bKey[1] & 0xFF) << 8) | (bKey[0] & 0xFF);
			break;
		default:
			assert false;
		}
		return rv & 0xffffffffL; /* Truncate to 32-bits */
	}

	/**
	 * Get the md5 of the given key.
	 */
	public static byte[] computeMd5(String k) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("MD5 not supported", e);
		}
		md5.reset();
		md5.update(KeyUtil.getKeyBytes(k));
		return md5.digest();
	}

	private static class KeyUtil {
		/**
		 * Get the bytes for a key.
		 * 
		 * @param k
		 *            the key
		 * @return the bytes
		 */
		public static byte[] getKeyBytes(String k) {
			try {
				return k.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}

		/**
		 * Get the keys in byte form for all of the string keys.
		 * 
		 * @param keys
		 *            a collection of keys
		 * @return return a collection of the byte representations of keys
		 */
		@SuppressWarnings("unused")
		public static Collection<byte[]> getKeyBytes(Collection<String> keys) {
			Collection<byte[]> rv = new ArrayList<byte[]>(keys.size());
			for (String s : keys) {
				rv.add(getKeyBytes(s));
			}
			return rv;
		}
	}
}
