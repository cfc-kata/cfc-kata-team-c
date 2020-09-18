package com.cfckata.common.util;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * @author shuwei.dou
 * @description
 * @date 2020/9/17 11:38
 * @copyright
 */
public class DateUtil {
    /**无分隔符的8位日期格式*/
    public static final String PATTERN_NO_SEP_ON_DAY = "yyyyMMdd";

    public static final String PATTERN_ON_DAY = "yyyy-MM-dd";

    /**无分隔符的8位日期格式*/
    public static final FastDateFormat FORMAT_NO_SEP_ON_DAY = FastDateFormat.getInstance(PATTERN_NO_SEP_ON_DAY);

    public static final FastDateFormat FORMAT_ON_DAY = FastDateFormat.getInstance(PATTERN_ON_DAY);

    public static String getCurDateNoSep(){
        return FORMAT_NO_SEP_ON_DAY.format(new Date());
    }
}
