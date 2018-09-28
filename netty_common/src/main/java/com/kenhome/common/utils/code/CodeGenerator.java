package com.kenhome.common.utils.code;

import org.apache.commons.lang3.time.DateUtils;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.UUID;

/**
 * 字符生成工具
 *
 * @author cmk
 * @version 1.0
 * @create 2018-09-17 09:10:22
 */
public class CodeGenerator {

    private static final long REFERENCE_TIME = getReferenceTime();//标准时间（单位：毫秒）

    private static long getReferenceTime() {
        try {
            return DateUtils.parseDate("20180101", "yyyyMMdd").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /**
     * 随机代码生成器（10进制以上）
     *
     * @param length 长度
     * @param radix  进制（11-36）
     * @return 随机串
     */
    public static String generate(int length, int radix) {
        if (radix <= 10 && radix > 36) {
            return null;
        }
        String nanoTime = Long.toString(System.nanoTime(), radix);
        if (length < nanoTime.length()) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        result.append(nanoTime);
        int supplementLength = length - result.length();
        while (supplementLength > 0) {
            int rn = new SecureRandom(UUID.randomUUID().toString().getBytes()).nextInt(radix);
            result.append(Integer.toString(rn, radix));
            supplementLength = length - result.length();
        }
        return result.substring(0, length);
    }

    /**
     * 10进制随机代码生成器
     *
     * @param length 长度
     * @param level  级别（true:秒级别，false微妙级别）
     * @return
     */
    public static String generate(int length, boolean level) {
        long passedTime = System.currentTimeMillis() - CodeGenerator.REFERENCE_TIME;
        if (level) {
            //转换为秒
            passedTime = passedTime / 1000L;
        }
        String passedTimeChar = String.valueOf(passedTime);
        if (passedTime <= 0 || length < passedTimeChar.length()) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        result.append(passedTimeChar);
        int supplementLength = length - result.length();
        while (supplementLength > 0) {
            int rn = new SecureRandom(UUID.randomUUID().toString().getBytes()).nextInt(10);
            result.append(rn);
            supplementLength = length - result.length();
        }
        return result.substring(0, length);
    }

    /**
     * 生成委托单号
     * @return
     */
    public static String generateEntrustNo(){
        return generate(12,false);
    }

    /**
     * 生成订单编号
     * * @return
     */
    public static String generateOrderNo(){
        return generate(16,false);
    }

}
