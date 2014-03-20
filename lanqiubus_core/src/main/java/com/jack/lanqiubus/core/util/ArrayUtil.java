package com.jack.lanqiubus.core.util;

import java.util.List;

public class ArrayUtil {

	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(List<?> array, Class<T> clz) {
		return (List<T>)array;
	}
}
