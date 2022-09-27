package io.github.kongpf8848.commonhelper;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnicodeHelper {

    /**
     * unicode转字符串
     * @param unicodeStr unicode
     * @return 字符串
     */
    public static String unicodeToString(String unicodeStr) {
        // XDigit是POSIX字符类，表示十六进制数字，\p{XDigit}等价于[a-fA-F0-9]
        // pattern用于匹配形如\\u6211的字符串
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(unicodeStr);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            unicodeStr = unicodeStr.replace(matcher.group(1), ch + "");
        }
        return unicodeStr;
    }

    /**
     * 字符串转unicode
     * @param str 字符串
     * @return unicode
     */
    public static String stringToUnicode(String str) {
        StringBuffer sb = new StringBuffer();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb.append("\\u" + Integer.toHexString(c[i]));
        }
        return sb.toString();
    }


}
