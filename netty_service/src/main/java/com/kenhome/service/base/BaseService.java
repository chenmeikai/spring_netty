package com.kenhome.service.base;

import com.kenhome.common.entity.BaseEntity;
import com.kenhome.common.model.universal.PageModel;

import java.util.List;

/**
 * 业务基本接口
 * <p color="red">注意：所有业务接口应继承自该类<p/>
 *
 * @author cmk
 * @version 1.0
 * @create 2018-09-18 16:21:17
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * 根据id查找单个对象
     *
     * @param id 对象id
     * @return
     */
    T findOne(String id);

    /**
     * 查询所有对象
     *
     * @return
     */
    List<T> findAll();

    /**
     * 分页查询所有对象
     *
     * @param page pageNum和pageSize必须指定
     * @return
     */
    PageModel<T> findPage(PageModel page);

    /**
     * 持久化对象
     *
     * @param entity 对象
     * @return
     */
    int save(T entity);

    /**
     * 持久化多个对象
     *
     * @param datas 对象列表
     * @return
     */
    int saveMultiple(List<T> datas);

    /**
     * 物理删除
     *
     * @param id 主键编号
     * @return
     */
    int delete(String id);

    /**
     * 更新
     *
     * @param entity 要更新的对象
     * @return
     */
    int update(T entity);


}
