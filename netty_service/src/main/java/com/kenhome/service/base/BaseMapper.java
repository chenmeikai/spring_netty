package com.kenhome.service.base;

import com.kenhome.common.entity.BaseEntity;
import com.kenhome.service.base.provider.ListProvider;
import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Mapper基本接口
 * <p color="red">注意：所有Mapper接口应继承自该类<p/>
 *
 * @author cmk
 * @version 1.0
 * @create 2018-09-18 13:17:52
 */
public interface BaseMapper<T extends BaseEntity> extends Mapper<T>, IdsMapper<T> {

    @InsertProvider(
            type = ListProvider.class,
            method = "dynamicSQL"
    )
    int insertList(List<T> recordList);

}
