package com.common.zyx.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yx.zhou
 * @Date: 2019/8/11
 * @Time: 14:38
 */

public class PageResult<T> {
    /**
     * 页数
     */
    private int pageCount = 1;

    /**
     * 总数据条数
     */
    private long total = 1;

    /**
     * 当前页码
     */
    private int currentPage = 1;

    /**
     * 每页数据条数
     */
    private int pageSize = 10;

    /**
     * 是否分页
     */
    private boolean enableTotal = true;

    private List<T> data = new ArrayList<>();

    public void setEnableTotal(boolean enableTotal) {
        this.enableTotal = enableTotal;
    }

    public boolean isEnableTotal() {
        return enableTotal;
    }

    public int getStart() {
        return pageSize * (currentPage - 1);
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public static <E> PageResult<E> create(int page, long count, List<E> data) {
        PageResult<E> pageResult = new PageResult<>();
        pageResult.setCurrentPage(page);
        pageResult.setTotal(count);
        pageResult.setData(data);
        return pageResult;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        if (total > 0 && pageSize > 0) {
            this.pageCount = (int) ((total - 1) / pageSize + 1);
        }
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
