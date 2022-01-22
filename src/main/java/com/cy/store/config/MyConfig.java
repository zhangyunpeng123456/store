package com.cy.store.config;

import jdk.nashorn.internal.runtime.AllocationStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @PackgeName: com.cy.store.config
 * @ClassName: MyConfig
 * @Author: zyp
 * Date: 2022/1/16 11:42
 * project name: store
 * @Version:
 * @Description:
 */
@Component
@PropertySource("classpath:config/my-web.properties")
@ConfigurationProperties( prefix = "user.address")
public class MyConfig {

    private Integer maxCount;

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public String toString() {
        return "MyConfig{" +
                "maxCount=" + maxCount +
                '}';
    }
}
