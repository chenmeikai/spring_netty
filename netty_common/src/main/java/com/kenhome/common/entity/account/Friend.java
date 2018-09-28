package com.kenhome.common.entity.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.kenhome.common.constant.account.SexEnum;
import com.kenhome.common.entity.BaseEntity;
import com.kenhome.common.utils.code.CodeGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\16 0016 17:58
 */

@Entity
@Table(name = "t_friend")
@Getter
@Setter
@ToString
public class Friend extends BaseEntity {

    @Column(name = "friend_id")
    private String friendId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "friend_name")
    private String friendName;

    @Column(name = "category_id")
    private String categoryId;

}
