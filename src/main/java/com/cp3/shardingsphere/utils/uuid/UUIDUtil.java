package com.cp3.shardingsphere.utils.uuid;

import cn.hutool.core.util.IdUtil;

/**
 * @Title: R
 * @Description:
 * @author: huhua
 * @date: 2021/3/13 18:04
 */
public class UUIDUtil {

    /**
     * 带-的UUID字符串
     * @return
     */
    public static String randomUUID(){
        return IdUtil.randomUUID();
    }
    /**
     * 不带-的UUID字符串，32位
     * @return
     */
    public static String simpleUUID(){
        return IdUtil.simpleUUID();
    }
}
