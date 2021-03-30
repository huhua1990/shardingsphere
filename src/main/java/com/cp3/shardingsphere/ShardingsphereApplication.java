package com.cp3.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@MapperScan("com.cp3.shardingsphere.mapper") 与@Repository 配合使用
//排除默认数据源自动装配
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShardingsphereApplication {

    public static void main(String[] args) {
        System.out.println("格式" + System.getProperty("file.encoding"));
        SpringApplication.run(ShardingsphereApplication.class, args);
    }

}

