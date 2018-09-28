package com.kenhome.common.model.universal;

import com.kenhome.common.constant.universal.ResponseEnum;
import com.kenhome.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: cmk
 * @Description: 响应标准模型
 * @Date: Created in 11:09 2018/9/19 0019
 * @Modified By:
 */
public class ResponseModel <T> extends BaseModel {

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String zhMessage;

    @Getter
    @Setter
    private String enMessage;

    @Getter
    @Setter
    private Long time;

    @Getter
    @Setter
    private T data;


    public ResponseModel(String code, String zhMessage, String enMessage) {
        init();
        this.code=code;
        this.zhMessage=zhMessage;
        this.enMessage=enMessage;
    }
    public ResponseModel(String code, String zhMessage) {
        init();
        this.code=code;
        this.zhMessage=zhMessage;
    }

    public  ResponseModel(String code, String zhMessage, String enMessage, T data) {
        init();
        this.code=code;
        this.zhMessage=zhMessage;
        this.enMessage=enMessage;
        this.data=data;
    }

    /*处理成功响应*/
    public static ResponseModel success() {
        return new ResponseModel(ResponseEnum.SUCCESS.name(), ResponseEnum.SUCCESS.zhMessage(), ResponseEnum.SUCCESS.enMessage());
    }

    public static ResponseModel success(ResponseEnum responseEnum) {
        return new ResponseModel(ResponseEnum.SUCCESS.name(), responseEnum.zhMessage(), responseEnum.enMessage());
    }
    public static ResponseModel success(String zhMessage) {
        return new ResponseModel(ResponseEnum.SUCCESS.name(), zhMessage);
    }
    //返回动态提示语
    public static ResponseModel successWithParameters(ResponseEnum responseEnum,Object... parameters) {
        String zhMessage = String.format(responseEnum.zhMessage(), parameters);
        String enMessage = String.format(responseEnum.enMessage(), parameters);
        return new ResponseModel(ResponseEnum.SUCCESS.name(),zhMessage ,enMessage );
    }

    public static <D> ResponseModel success(D data) {
        return new ResponseModel(ResponseEnum.SUCCESS.name(), ResponseEnum.SUCCESS.zhMessage(), ResponseEnum.SUCCESS.enMessage(), data);
    }

    public static <D> ResponseModel success(ResponseEnum responseEnum,D data) {
        return new ResponseModel(ResponseEnum.SUCCESS.name(), responseEnum.zhMessage(), responseEnum.enMessage(), data);
    }




    /*处理失败响应*/
    public static ResponseModel fail() {
        return new ResponseModel(ResponseEnum.FAIL.name(), ResponseEnum.FAIL.zhMessage(), ResponseEnum.FAIL.enMessage());
    }

    public static ResponseModel fail(ResponseEnum responseEnum) {
        return new ResponseModel(responseEnum.name(), responseEnum.zhMessage(), responseEnum.enMessage());
    }

    public static ResponseModel fail(String zhMessage) {
        return new ResponseModel(ResponseEnum.FAIL.name(), zhMessage);
    }
    //返回动态提示语
    public static ResponseModel failWithParameters(ResponseEnum responseEnum,Object... parameters) {
        String zhMessage = String.format(responseEnum.zhMessage(), parameters);
        String enMessage = String.format(responseEnum.enMessage(), parameters);
        return new ResponseModel(responseEnum.name(),zhMessage ,enMessage );
    }

    public static <D> ResponseModel fail(ResponseEnum responseEnum,D data) {
        return new ResponseModel(responseEnum.name(), responseEnum.zhMessage(), responseEnum.enMessage(), data);
    }




    private void init() {
        if (time == null) {
            time = System.currentTimeMillis();
        }
    }

}
