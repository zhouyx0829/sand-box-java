package com.common.mvc.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author: yx.zhou
 * @Date: 2019/7/31
 * @Time: 21:35
 */

public class EnvUtils {
    public static String[] initEnvFromSystem(String[] args, String systemEnvkey, String programEnvKey, String defaultEnv) {
        String env = System.getenv(systemEnvkey);
        env = StringUtils.isNotBlank(env) ? env : System.getProperty(systemEnvkey);
        boolean hasEnv = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains(programEnvKey)) {
                hasEnv = true;
                if (StringUtils.isNotBlank(env)) {
                    args[i] = programEnvKey + env;
                }
            }
        }
        env = StringUtils.isNotBlank(env) ? env : defaultEnv;
        if (!hasEnv) {
            String[] newArgs = Arrays.copyOf(args, args.length + 1);
            newArgs[args.length] = programEnvKey + env;
            args = newArgs;
        }
        return args;
    }
}
