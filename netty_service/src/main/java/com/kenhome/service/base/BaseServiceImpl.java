package com.kenhome.service.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kenhome.common.entity.BaseEntity;
import com.kenhome.common.model.universal.PageModel;
import com.kenhome.common.utils.PageConvert;

import java.util.List;

/**
 * 业务实现基本类
 * <p color="red">注意：所有业务实现类应继承自该类<p/>
 *
 * @author cmk
 * @version 1.0
 * @create 2018-09-18 16:36:25
 */
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected abstract BaseMapper<T> getBaseMapper();

    @Override
    public T findOne(String id) {
        return this.getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return this.getBaseMapper().selectAll();
    }

    @Override
    public PageModel<T> findPage(PageModel page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<T> list = this.getBaseMapper().selectAll();
        PageInfo<T> pageinfo = new PageInfo<T>(list);
        PageModel<T> result = PageConvert.convert(pageinfo);
        return result;
    }

    @Override
    public int save(T entity) {
        entity.init();
        return this.getBaseMapper().insertSelective(entity);
    }

    @Override
    public int saveMultiple(List<T> datas) {
        datas.forEach(data -> data.init());
        return this.getBaseMapper().insertList(datas);
    }

    @Override
    public int delete(String id) {
        return this.getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int update(T entity) {
        return this.getBaseMapper().updateByPrimaryKeySelective(entity);
    }

}
