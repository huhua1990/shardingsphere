package com.cp3.shardingsphere.utils.twitter;

/**
 * @Title: IdWorkerUtils
 * @Description:
 * @author: huhua
 * @date: 2021/3/29 21:00
 */
public class IdWorkerUtils {
    private static IdWorker worker = new IdWorker(1,1);
    public static long getId() {
        return worker.nextId();
    }
}
