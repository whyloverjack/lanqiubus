package com.jack.lanqiubus.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * User: yexiaowei
 * Date: 13-11-6
 * Time: 上午11:15
 * description:
 */
public class SimpleSet<E> extends HashSet<E> {
    public SimpleSet() {
        super();
    }

    @Override
    public String toString() {
        Iterator<E> i = iterator();
        if (!i.hasNext())
            return "";

        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            E e = i.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!i.hasNext())
                return sb.toString();
            sb.append(", ");
        }
    }
}
