package com.zyx.eureka;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;

/**
 * @author: yx.zhou
 * @Date: 2019/7/31
 * @Time: 21:38
 */

public class App {
    public static void main(String[] args) {
        args = initEnvFromSystem(args, "ENV_SYSTEM");
        SpringApplication.run(App.class, args);
    }

    public static String[] initEnvFromSystem(String[] args, String key) {
        String env = System.getenv(key);
        env = StringUtils.isNotBlank(env) ? env : System.getProperty(key);
        if (StringUtils.isNotBlank(env)) {
            String envArgs = String.format("--spring.profiles.active=%s", env);
            if (args.length > 0) {
                args[0] = envArgs;
            } else {
                args = new String[]{envArgs};
            }
        }
        return args;
    }
}
