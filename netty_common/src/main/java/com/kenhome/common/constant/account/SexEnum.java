package com.kenhome.common.constant.account;

import lombok.Getter;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 17:40 2018/9/18 0018
 * @Modified By:
 */
@Getter
public enum SexEnum {

    BOY("男"),
    GIRL("女"),
    UNKNOWN("未知");

    private String name;

    SexEnum(String content) {
        this.name=content;
    }
}
