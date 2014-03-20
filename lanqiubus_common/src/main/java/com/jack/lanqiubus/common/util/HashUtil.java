package com.jack.lanqiubus.common.util;

/**
 * User: yexiaowei
 * Date: 13-11-18
 * Time: 下午4:33
 * description:
 */
public class HashUtil {
    public static long hash(String str) {
        return HashAlgorithmHelper.FNV1A_64_HASH.hash(str);
    }
}
