package com.kenhome.common.constant.universal;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 11:33 2018/9/19 0019
 * @Modified By:
 */
public enum ResponseEnum {

    SUCCESS, //处理成功
    FAIL,    //处理失败
    ERROR,   //系统错误

    NECESSARY_PARAMETERS, //缺少必要参数

    NO_ENOUGH_AGE; //某某未满n周岁


    private String zhMessage;
    private String enMessage;

    public String  zhMessage(){
        return this.zhMessage;
    }
    public String  enMessage(){
        return this.enMessage;
    }

    private ResponseEnum() {
        try {
            ResourceBundle zhResource = ResourceBundle.getBundle("response", Locale.SIMPLIFIED_CHINESE);
            ResourceBundle enResource = ResourceBundle.getBundle("response", Locale.US);
            this.zhMessage = zhResource.getString(this.name());
            this.enMessage = enResource.getString(this.name());
        } catch (Exception e) {
            System.err.println(String.format("%s 获取 Message 配置信息失败！", this.name()));
        }
    }
}
