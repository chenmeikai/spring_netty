package com.kenhome.common.model.universal;

import com.kenhome.common.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * 分页对象模型
 *
 * @author cmk
 * @version 1.0
 * @create 2018-09-18 16:55:21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageModel<T> extends BaseModel {

    public static final PageModel EMPTY_PAGE_MODEL = new PageModel(1,10,0,0,0,0,1, Collections.emptyList(),
            1,1,true,true,false,false);

    public PageModel(int pageNum) {
        this.pageNum = pageNum;
        this.pageSize = 10;
    }

    public PageModel(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    private int pageNum;//当前页码

    private int pageSize;//每页最大个数

    private int size;//当前页实际个数

    private int startRow;//起始行

    private int endRow;//结束行

    private long total;//总个数

    private int pages;//总页数

    private List<T> list;//数据

    private int prePage;//上一页页码

    private int nextPage;//下一页页码

    private boolean isFirstPage;//是否是第一页

    private boolean isLastPage;//是否是最后一页

    private boolean hasPreviousPage;//是否有上一页

    private boolean hasNextPage;//是否有下一页

}
