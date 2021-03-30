package com.cp3.shardingsphere.utils.shardingsphere;

import com.cp3.shardingsphere.utils.shardingsphere.SnowflakeShardingKeyGenerator;

/**
 * @Title: SnowFlakeUtil
 * @Description:   4.x提供新的集成方式 可直接yml配置
 * @author: huhua
 * @date: 2021/3/13 18:04
 */
public class SnowFlakeUtil {
    public static Comparable<?>  getId(Long workerId) {
        if (!(workerId >= 0 && workerId < 1024L)) {
            throw new RuntimeException(String.format("workerId is not support range must be [0,1024)"));
        }
        SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();
        snowflakeShardingKeyGenerator.getProperties().put("worker.id", String.valueOf(workerId));
        Comparable<?> generateKey = snowflakeShardingKeyGenerator.generateKey();
        return generateKey;
    }
}
