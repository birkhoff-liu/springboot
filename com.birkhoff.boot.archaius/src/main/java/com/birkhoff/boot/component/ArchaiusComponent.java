package com.birkhoff.boot.component;

import com.birkhoff.boot.archaius.config.dynamic.DynamicConfigurationSource;
import com.netflix.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ArchaiusComponent {
    @Bean
    public void config(){
        System.setProperty("archaius.fixedDelayPollingScheduler.initialDelayMills", "0");  //初始延时0毫秒
        System.setProperty("archaius.fixedDelayPollingScheduler.delayMills", "10000");
        PolledConfigurationSource source = new DynamicConfigurationSource();
        //其实FixedDelayPollingScheduler本身的构造函数也可以设置延时加载和定时调度间隔,使用构造配置会覆盖系统配置
        AbstractPollingScheduler scheduler = new FixedDelayPollingScheduler();
        DynamicConfiguration configuration = new DynamicConfiguration(source, scheduler);
        ConfigurationManager.install(configuration);
    }
}
