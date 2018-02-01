package blk.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 项目工具类
 * @author Mark
 * @date 2018/1/24
 */
public class CommonUtils {
    /**
     * 使用正则表达式验证字符串是否为数字
     * @param str 待验证字符串
     * @return true 该字符串为数字
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^-?\\d+(?:.\\d+)?$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 使用正则表达式验证字符串是否为数字
     * @param str 待验证字符串
     * @return true 该字符串不是数字
     */
    public static boolean isNotNumeric(String str) {
        return !isNumeric(str);
    }

    /**
     * 获取当前日期字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String getStrDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    /**
     * 获取格式化日期
     * @param format 默认"yyyyMMddHHmmss"
     * @return
     */
    public static String getFormatDate(String format) {
        format = (format == null || format == "") ? "yyyyMMddHHmmss" : format;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 读取配置文件的公用方法
     *
     * @param path
     *            路径地址
     * @param key
     *            需要读取参数的key值
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String getProperties(String path, String key) {
        String value = null;
        InputStream ins = null;
        try {
            Class cls = CommonUtils.class;
            ClassLoader loader = cls.getClassLoader();

            ins = loader.getResourceAsStream(path);
            Properties prop = new Properties();

            prop.load(ins);// 从流中获取数据
            value = prop.getProperty(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return value;
    }

    /**
     * 将Excel列数值转换为字母
     * @param num
     * @return
     */
    public static String toRadix(int num) {
        String[] array = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int count = 26;
        String out;
        if(num/count != 0){
            out = array[num/count - 1];
            if(num%count == 0){
                out = out + array[num%count];
            }else{
                out = out + array[num%count - 1];
            }
        }else{
            out = array[num -1 ];
        }
        return out;
    }
}
