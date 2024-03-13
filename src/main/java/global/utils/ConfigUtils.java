package global.utils;

import org.thymeleaf.util.StringUtils;

public class ConfigUtils {

    // dev 환경 여부 check
    public static final boolean IS_DEV;

    static {
        String profile = System.getProperty("spring.profiles.active");
        IS_DEV = StringUtils.equals(profile, "dev");
    }
}
