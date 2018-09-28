package com.kenhome.common.utils;

import com.github.pagehelper.PageInfo;
import com.kenhome.common.model.universal.PageModel;

import java.io.Serializable;

/**
 * PageConvert
 *
 * @author cmk
 * @version 1.0
 * @create 2018-09-18 17:37:33
 */
public class PageConvert {

    public static <T extends Serializable> PageModel<T> convert(PageInfo<T> pageInfo) {
        PageModel<T> result = new PageModel<T>();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setSize(pageInfo.getSize());
        result.setStartRow(pageInfo.getStartRow());
        result.setEndRow(pageInfo.getEndRow());
        result.setTotal(pageInfo.getTotal());
        result.setPages(pageInfo.getPages());
        result.setList(pageInfo.getList());
        result.setPrePage(pageInfo.getPrePage());
        result.setNextPage(pageInfo.getNextPage());
        result.setFirstPage(pageInfo.isIsFirstPage());
        result.setLastPage(pageInfo.isIsLastPage());
        result.setHasPreviousPage(pageInfo.isHasPreviousPage());
        result.setHasNextPage(pageInfo.isHasNextPage());
        return result;
    }

}
