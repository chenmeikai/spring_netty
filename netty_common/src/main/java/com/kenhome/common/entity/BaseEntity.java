package com.kenhome.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kenhome.common.utils.code.EntityIdGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体基本类
 * @author cmk
 * @version 1.0
 * @create 2018-9-17 10:32:02
 */
@MappedSuperclass
@ToString
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private String id;

    @Column(name = "create_date")
    @Getter
    @Setter
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 初始化实体基本属性
     * <p color="red">注意：实体持久化到数据库前应先调用该方法<p/>
     */
    public void init() {
        this.id = EntityIdGenerator.generateId();
        this.createDate = new Date();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!BaseEntity.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        return getId() != null ? getId().equals(other.getId()) : false;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += this.getId() != null ? getId().hashCode() * 31 : 0;
        return hashCode;
    }

}
