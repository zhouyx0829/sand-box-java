package com.boottest;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@SpringBootApplication
//@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({"com.shanhs.recycle.*", "com.shanhs.common.*"})
@EnableAsync(proxyTargetClass=true)
//@EnableMQConfiguration
//@EnabledDistributedScheduled
public class BoottestApp {
//    @Bean
//    public DefaultCatalog schema() {
//        return DefaultCatalog.DEFAULT_CATALOG;
//    }
//
//    public static void main(String[] args) {
//        args = EnvUtils.initEnvFromSystem(
//                args,
//                "ENV_SYSTEM",
//                "--spring.profiles.active=",
//                "dev");
//        SpringApplication.run(RecycleXiaomiApp.class, args);
//    }
}

