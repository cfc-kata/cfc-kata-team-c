//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cfckata.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringUtils {
    private static final Logger log = LoggerFactory.getLogger(StringUtils.class);
    public static final char UNDERLINE = '_';
    public static final String PLACE_HOLDER = "{%s}";
    private static final String TRIM_LEFT_REGEX = "^[�� ]+";
    private static final String TRIM_RIGHT_REGEX = "[�� ]+$";
    private static final String BLANK_STR = "";

    public StringUtils() {
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static boolean isEmpty(String value) {
        return value == null || value.trim().equals("");
    }

    public static boolean isNotEmpty(Object value) {
        return !isEmpty(value);
    }

    public static boolean isEmpty(Object value) {
        return value == null;
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static boolean isEmpty(List<?> list) {
        if (list == null) {
            return true;
        } else {
            return list.size() <= 0;
        }
    }

    public static boolean isNotEmptyAll(String value) {
        return !isEmptyAll(value);
    }

    public static boolean isEmptyAll(String value) {
        return value == null || value.trim().equals("") || value.trim().equals("null");
    }

    public static String getBirthDayByIdNo(String idNo) {
        String birthDate = "";
        if (idNo.length() == 15) {
            birthDate = "19" + idNo.substring(6, 8) + "-" + idNo.substring(8, 10) + "-" + idNo.substring(10, 12);
        } else if (idNo.length() == 18) {
            birthDate = idNo.substring(6, 10) + "-" + idNo.substring(10, 12) + "-" + idNo.substring(12, 14);
        }

        return birthDate;
    }

    public static String getYearsByBirth(String birthDate) {
        String years = "";
        Date date = new Date();
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sfm.format(date);

        try {
            Date d1 = sfm.parse(birthDate);
            Date d2 = sfm.parse(currentDate);
            long days = (d2.getTime() - d1.getTime()) / 86400000L + 1L;
            years = (new DecimalFormat("#")).format((double)((float)days / 365.0F));
        } catch (Exception var9) {
        }

        return years;
    }

    public static String formatSeq(String fileContent, String seqStr, Integer length) {
        StringBuilder sb = new StringBuilder();
        int offset = length - seqStr.length();

        for(int i = 0; i < offset; ++i) {
            sb.append(fileContent);
        }

        return sb.toString() + seqStr;
    }

   
    public static String camelToUnderline(String param) {
        if (isEmpty(param)) {
            return "";
        } else {
            int len = param.length();
            StringBuilder sb = new StringBuilder(len);

            for(int i = 0; i < len; ++i) {
                char c = param.charAt(i);
                if (Character.isUpperCase(c) && i > 0) {
                    sb.append('_');
                }

                sb.append(Character.toLowerCase(c));
            }

            return sb.toString();
        }
    }

    public static String firstToLowerCase(String param) {
        if (isEmpty(param)) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder(param.length());
            sb.append(param.substring(0, 1).toLowerCase());
            sb.append(param.substring(1));
            return sb.toString();
        }
    }

    public static boolean isUpperCase(String str) {
        return match("^[A-Z]+$", str);
    }

    public static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean endWith(CharSequence sequence, char c) {
        if (isEmpty((CharSequence)sequence)) {
            return false;
        } else {
            return sequence.charAt(sequence.length() - 1) == c;
        }
    }


    public static String concatCapitalize(String concatStr, String str) {
        if (isEmpty(concatStr)) {
            concatStr = "";
        }

        if (str != null && !str.isEmpty()) {
            char firstChar = str.charAt(0);
            if (Character.isTitleCase(firstChar)) {
                return str;
            } else {
                StringBuilder sb = new StringBuilder(str.length());
                sb.append(concatStr);
                sb.append(Character.toTitleCase(firstChar));
                sb.append(str.substring(1));
                return sb.toString();
            }
        } else {
            return str;
        }
    }

    public static Boolean isCharSequence(Class<?> cls) {
        return cls != null && CharSequence.class.isAssignableFrom(cls);
    }

    public static Boolean isCharSequence(String propertyType) {
        Class cls;
        try {
            cls = Class.forName(propertyType);
        } catch (ClassNotFoundException var3) {
            return false;
        }

        return isCharSequence(cls);
    }
    
    public static String checkNullAndReturnString(Object o) {
        String result = "";
        if (o != null && !"null".equals(o)) {
            result = o.toString().trim();
        }

        return result;
    }

    public static String checkNullAndReturnDefVal(Object o, String defVal) {
        String result = "";
        if (o != null && !"null".equals(o) && !"".equals(o)) {
            result = o.toString().trim();
        } else {
            result = defVal;
        }

        return result;
    }

    public static BigDecimal checkNullAndReturnBigDecimal(Object o) {
        String defVal = "0";
        return checkNullAndReturnBigDecimal(o, defVal);
    }

    public static BigDecimal checkNullAndReturnBigDecimal(Object o, String defVal) {
        if (o != null) {
            return o instanceof BigDecimal ? (BigDecimal)o : new BigDecimal("".equals(o.toString()) ? "0" : o.toString());
        } else {
            return new BigDecimal(defVal);
        }
    }

    public static Integer checkNullAndReturnInteger(String sourceStr) {
        return checkNullAndReturnInteger(sourceStr, (Integer)null);
    }

    public static Integer checkNullAndReturnInteger(String sourceStr, Integer defVal) {
        return isEmpty(sourceStr) ? defVal : Integer.valueOf(sourceStr);
    }

    public static boolean pwdVerify(String password) {
        if (isEmptyAll(password)) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W,_])[^\b]{8,20}$");
            return pattern.matcher(password).matches();
        }
    }

    public static boolean equalsIn(String str, String... args) {
        if (isEmpty(str)) {
            return false;
        } else {
            if (args != null) {
                int length = args.length;
                if (length >= 1) {
                    String[] var3 = args;
                    int var4 = args.length;

                    for(int var5 = 0; var5 < var4; ++var5) {
                        String arg = var3[var5];
                        if (str.equals(arg)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    public static String firstToUpperCase(String param) {
        if (isEmpty(param)) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder(param.length());
            sb.append(param.substring(0, 1).toUpperCase());
            sb.append(param.substring(1));
            return sb.toString();
        }
    }

    public static String trimLeft(String str) {
        return str != null && !"".equals(str) ? str.replaceAll("^[�� ]+", "") : str;
    }

    public static String trimRight(String str) {
        return str != null && !"".equals(str) ? str.replaceAll("[�� ]+$", "") : str;
    }
}
