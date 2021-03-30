package com.cp3.shardingsphere.utils;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Title: OrderTablesPreciseShardingAlgorithm
 * @Description: 分表算法：精确分片算法，适应于=和IN
 * @author: huhua
 * @date: 2021/3/13 18:04
 */
public class OrderTablesPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    /**
     *
     * @param collection  表名集合
     * @param preciseShardingValue 分片列
     * @return
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        // 获取分片字段值
        String value = preciseShardingValue.getValue();
        // 自定义算法:
        // 取末位%2求余: 如果是0则order0,如果是1则order1。
        value = value.substring(value.length()-1,value.length());
        int result = Integer.valueOf(value) % 2;
        for (String s : collection) {
            if(s.endsWith(result+"")){
                return s;
            }
        }
        throw new UnsupportedOperationException();
    }

}
