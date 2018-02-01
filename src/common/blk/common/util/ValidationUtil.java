package blk.common.util;

import java.util.regex.Pattern;

/**
 * 参数检验工具类
 * @author Mark
 * @date 2018/1/17
 */
public class ValidationUtil {
    private static final Pattern positiveNumericPattern = Pattern.compile("^[1-9]\\d*$");

    /**
     * 字符串是否不为空
     * @param cs
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static boolean isNotEmpty(final CharSequence cs, String errorCode, String errorMsg) {
        return !isEmpty(cs, errorCode, errorMsg);
    }

    /**
     * 字符串是否为空
     * @param cs
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static boolean isEmpty(final CharSequence cs, String errorCode, String errorMsg) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 是否为正整数
     * @param cs
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static boolean isPositiveNumeric(final CharSequence cs, String errorCode, String errorMsg) {
        return positiveNumericPattern.matcher(cs).matches();
    }
}
