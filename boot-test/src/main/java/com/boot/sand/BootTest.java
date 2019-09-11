package com.boot.sand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: yx.zhou
 * @Date: 2019/7/30
 * @Time: 21:35
 */
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({"com.boot.*", "com.common.*"})
@EnableAsync(proxyTargetClass=true)
public class BootTest {

    public static void main(String[] args) {
//        System.setProperty("io.netty.allocator.type", "unpooled");
//        args = EnvUtils.initEnvFromSystem(
//            args,
//            "ENV_SYSTEM",
//            "--spring.profiles.active=",
//            "dev");
        SpringApplication.run(BootTest.class, args);
    }
}
